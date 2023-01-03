package com.relationships.relationships.config;

import com.relationships.relationships.model.Role;
import com.relationships.relationships.model.RoleType;
import com.relationships.relationships.model.UserEntity;
import com.relationships.relationships.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (userRepository.findUserByEmail("adesuuse@rgmail.com").isEmpty()){
            UserEntity user = new UserEntity("Admin", "User","adesuuser@gmail.com", passwordEncoder.encode("password1234#"), RoleType.ADMIN);
            userRepository.save(user);
        }
    }
}