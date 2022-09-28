package com.service.product.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.service.product.models.EmailModel;
import com.service.product.models.StatusEmail;
import com.service.product.repository.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;

	@Autowired
	private JavaMailSender emailSender;

	public EmailModel sendEmail(EmailModel email) {
		email.setSendDateEmail(LocalDateTime.now());

		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getEmailFrom());
			message.setTo(email.getEmailTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			emailSender.send(message);
			email.setStatusEmail(StatusEmail.SEND);

		} catch (Exception e) {
			email.setStatusEmail(StatusEmail.ERROR);
		}

		return emailRepository.save(email);

	}

	public List<EmailModel> retrieveEmail() {
		List<EmailModel> emails = emailRepository.findAll();
		return emails;
	}
}
