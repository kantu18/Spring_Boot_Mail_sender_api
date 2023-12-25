package com.example.demo.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Mail_sender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class Mail_Sender_Service {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String from;
	
	public void sendmail(MultipartFile[] multifile,String mail, Mail_sender sender) throws InterruptedException, ExecutionException, MessagingException, IOException
	{	
					MimeMessage message=javaMailSender.createMimeMessage();
					MimeMessageHelper helper=new MimeMessageHelper(message,true);
					
					helper.setFrom(from);
					helper.setTo(mail);
					helper.setText(sender.getMessage());
					helper.setSubject(sender.getSubject());
					helper.setPriority(1);
					helper.setSentDate(new Date());
					
					for(int i=0;i<multifile.length;i++)
					{
						helper.addAttachment(multifile[i].getOriginalFilename(), new ByteArrayResource(multifile[i].getBytes()));
					}
					
					javaMailSender.send(message);
	}
}
