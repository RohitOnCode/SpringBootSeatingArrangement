package com.seating.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

	
	
@Component
	public class EmailSender {
		

		@Autowired
	    private JavaMailSender javaMailSender;
		
		
	 public void sendEmail(String ...addresses ) {

	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(addresses);

	        msg.setSubject("Testing from Spring Boot");
	        msg.setText("Hello World \n Spring Boot Email");

	        javaMailSender.send(msg);

	    }
	 
	 
	}