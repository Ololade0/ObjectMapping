package com.relationships.relationships.repository;

import com.relationships.relationships.model.AddressEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<AddressEntity, String> {
}
