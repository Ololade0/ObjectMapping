package com.relationships.relationships.repository;

import com.relationships.relationships.model.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
 UserEntity findByEmail(String email);
 UserEntity findFirstByEmail(String email);
 UserEntity findFirstById(String id);

 Optional<UserEntity>findUserByEmail(String email);

}
