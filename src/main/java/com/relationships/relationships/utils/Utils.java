package com.relationships.relationships.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {
    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String NUMBER = "1234567890";

    public String generateUserId(int length){
        return generateRandomString(length);
    }


    public String generateAddressId(int length){
        return generateRandomString(length);
    }


    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(NUMBER.charAt(RANDOM.nextInt(NUMBER.length())));

        }
        return new String(returnValue);
    }
}
