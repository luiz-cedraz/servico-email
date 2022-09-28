package com.service.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.product.dtos.EmailDTO;
import com.service.product.models.EmailModel;
import com.service.product.services.EmailService;

@RestController
public class EmailController {
	@Autowired
	private EmailService emailService;

	@PostMapping("/send-email")
	public ResponseEntity<EmailModel> sendEmail(@RequestBody EmailDTO dto) {
		EmailModel emailModel = new EmailModel();
		emailModel.setEmailFrom(dto.getEmailFrom());
		emailModel.setEmailTo(dto.getEmailTo());
		emailModel.setSubject(dto.getSubject());
		emailModel.setText(dto.getText());

		emailService.sendEmail(emailModel);
		return new ResponseEntity<>(emailModel, HttpStatus.OK);
	}

	@GetMapping("/retrieve-email")
	public ResponseEntity<List<EmailModel>> retrieveEmail() {
		List<EmailModel> emails = emailService.retrieveEmail();
		return new ResponseEntity<List<EmailModel>>(emails, HttpStatus.OK);
	}
}
