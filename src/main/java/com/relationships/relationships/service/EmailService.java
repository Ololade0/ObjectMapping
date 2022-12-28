package com.relationships.relationships.service;

import com.relationships.relationships.model.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details);
}
