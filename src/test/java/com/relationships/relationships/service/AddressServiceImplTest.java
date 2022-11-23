package com.relationships.relationships.service;;
import com.relationships.relationships.model.AddressEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AddressServiceImplTest {
    @Autowired
    private AddressService addressService;
    @Test
    void createAddress() {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCountry("Nigeria");
        addressEntity.setPostalCode("1000");
        addressEntity.setCity("Ikeja");
        addressEntity.setType("Shipping address");
     AddressEntity addressEntity1=   addressService.save(addressEntity);
        assertEquals("Ikeja", addressEntity1.getCity());

    }
}