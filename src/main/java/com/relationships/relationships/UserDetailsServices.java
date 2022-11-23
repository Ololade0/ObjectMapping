package com.relationships.relationships;

import com.relationships.relationships.exception.UserCannotBeFoundExcepttion;
import com.relationships.relationships.model.UserEntity;
import com.relationships.relationships.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsServices implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = null;
        try{
            user = userService.findByEmail(username);
            return new SecureUser(user);

        }
        catch (UserCannotBeFoundExcepttion e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
