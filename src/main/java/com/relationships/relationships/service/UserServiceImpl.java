package com.relationships.relationships.service;
import com.relationships.relationships.dao.request.UserLoginRequestModel;
import com.relationships.relationships.dao.response.UserLoginResponse;
import com.relationships.relationships.dto.UserDto;
import com.relationships.relationships.model.AddressEntity;
import com.relationships.relationships.model.Role;
import com.relationships.relationships.model.UserEntity;
import com.relationships.relationships.repository.AddressRepository;
import com.relationships.relationships.repository.UserRepository;
import com.relationships.relationships.utils.Utils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;



    private final Utils utils;



    @Override
    public UserDto createUser(UserDto user) {
        List<AddressEntity> addressEntity = new ArrayList<>();
        for (int i = 0; i < user.getAddresses().size(); i++) {
            AddressEntity address = new AddressEntity();
            address.setAddressId(String.valueOf(i));
            String publicAddressId = utils.generateUserId(30);
            address.setAddressId(publicAddressId);
            address.setCity(user.getAddresses().get(i).getCity());
            address.setCountry(user.getAddresses().get(i).getCountry());
            address.setPostalCode(user.getAddresses().get(i).getPostalCode());
            address.setType(user.getAddresses().get(i).getType());
            address.setStreetName(user.getAddresses().get(i).getStreetName());

           AddressEntity addressEntity1 = addressRepository.save(address);
            addressEntity.add(addressEntity1);
        }

        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setAddresses(addressEntity);
        userEntity.setRole(Role.USER);
        UserEntity returnValue = userRepository.save(userEntity);
        return modelMapper.map(returnValue, UserDto.class);


    }

    @Override
    public UserEntity findByEmail(String email) {
       return userRepository.findFirstByEmail(email);
    }

    @Override
    public UserEntity findById(String id) {
        UserEntity foundUser = userRepository.findFirstById(id);
        if(foundUser != null){
            return foundUser;

    }
       throw new RuntimeException("Does not exist");

    }

    @Override
    public UserLoginResponse login(UserLoginRequestModel userLoginRequestModel) {
        var user = userRepository.findFirstByEmail(userLoginRequestModel.getEmail());
        if(user != null && user.getPassword().equals(userLoginRequestModel.getPassword()));
        return buildSuccessfulLoginResponse(user);


    }

    private UserLoginResponse buildSuccessfulLoginResponse(UserEntity user) {
        return UserLoginResponse.builder()
                .code(200)
                .message("Login successful")
                .build();

    }

}

