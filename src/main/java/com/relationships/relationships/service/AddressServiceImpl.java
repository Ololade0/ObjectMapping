package com.relationships.relationships.service;

import com.relationships.relationships.dto.AddressDto;
import com.relationships.relationships.dto.UserDto;
import com.relationships.relationships.model.AddressEntity;
import com.relationships.relationships.model.Role;
import com.relationships.relationships.model.UserEntity;
import com.relationships.relationships.repository.AddressRepository;
import com.relationships.relationships.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;
    @Override
    public AddressEntity save(AddressEntity address) {
        ModelMapper modelMapper = new ModelMapper();
        AddressEntity addressEntity = modelMapper.map(address, AddressEntity.class);
        addressEntity.setStreetName(address.getStreetName());
        addressEntity.setCountry(addressEntity.getCountry());
        addressEntity.setPostalCode(addressEntity.getPostalCode());
//        userEntity.setRole(Role.USER);
        AddressEntity returnValue = addressRepository.save(addressEntity);
        return modelMapper.map(returnValue, AddressEntity.class);


    }
}
