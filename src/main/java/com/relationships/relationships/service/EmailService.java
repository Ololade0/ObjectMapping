package com.relationships.relationships.service;


import com.mashape.unirest.http.exceptions.UnirestException;
import com.relationships.relationships.dao.request.MailRequest;
import com.relationships.relationships.dao.response.MailResponse;

import java.util.concurrent.CompletableFuture;

public interface EmailService {
    CompletableFuture<MailResponse> sendSimpleMail(MailRequest mailRequest) throws UnirestException;
}
