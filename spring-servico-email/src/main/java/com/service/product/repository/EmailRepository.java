package com.service.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.service.product.models.EmailModel;

public interface EmailRepository extends MongoRepository<EmailModel, String> {

}
