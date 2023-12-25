package com.example.demo.controller;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Mail_sender;
import com.example.demo.service.Mail_Sender_Service;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api")
public class Mail_Sender_controller {
	
	
	@Autowired
	private Mail_Sender_Service mail_Sender_Service;
	
	@PostMapping("/send/{mail}")
	public String sendemail(@RequestParam(value="file", required = false)MultipartFile[] multifile, @PathVariable String mail, @ModelAttribute Mail_sender sender) throws InterruptedException, ExecutionException, MessagingException, IOException
	{
		mail_Sender_Service.sendmail(multifile, mail, sender);
		return "Successfully Sent!!";
	}
}
