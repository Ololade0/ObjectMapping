package com.relationships.relationships.repository;

import com.relationships.relationships.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
 UserEntity findFirstByEmail(String email);
 UserEntity findFirstById(String id);


}
