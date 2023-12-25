package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Mail_Sender")
public class Mail_sender {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Subject")
	private String subject;
	
	@Column(name="Message")
	private String message;
	
	@Column(name="CC")
	private String cc;
	
	
	public Mail_sender() {
		super();
	}

	public Mail_sender(int id, String subject, String message, String cc) {
		super();
		this.id = id;
		this.cc= cc;
		this.subject = subject;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	@Override
	public String toString() {
		return "Mail_sender [id=" + id + ", subject=" + subject + ", message=" + message + ", cc=" + cc + "]";
	}
	
}
