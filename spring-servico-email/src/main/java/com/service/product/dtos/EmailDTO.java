package com.service.product.dtos;

import java.time.LocalDateTime;

import com.service.product.models.StatusEmail;

public class EmailDTO {
	private String id;
	private String ownerRef;
	private String emailFrom;
	private String emailTo;
	private String subject;
	private LocalDateTime sendDateEmail;
	private String text;
	private StatusEmail statusEmail;

	public EmailDTO() {

	}

	public EmailDTO(String id, String ownerRef, String emailFrom, String emailTo, String subject,
			LocalDateTime sendDateEmail, String text, StatusEmail statusEmail) {
		this.id = id;
		this.ownerRef = ownerRef;
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.subject = subject;
		this.sendDateEmail = sendDateEmail;
		this.text = text;
		this.statusEmail = statusEmail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwnerRef() {
		return ownerRef;
	}

	public void setOwnerRef(String ownerRef) {
		this.ownerRef = ownerRef;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public LocalDateTime getSendDateEmail() {
		return sendDateEmail;
	}

	public void setSendDateEmail(LocalDateTime sendDateEmail) {
		this.sendDateEmail = sendDateEmail;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public StatusEmail getStatusEmail() {
		return statusEmail;
	}

	public void setStatusEmail(StatusEmail statusEmail) {
		this.statusEmail = statusEmail;
	}

}
