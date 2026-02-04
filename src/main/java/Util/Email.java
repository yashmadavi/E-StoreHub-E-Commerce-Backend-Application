package com.my.Ecommerce.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component    // used to define class to configuration
public class Email {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String to) {
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(to);
		mail.setFrom("yashmadavi93@gmail.com");
		mail.setText("mail has been sent");
		mail.setSubject("Conformation email");
		
		mailSender.send(mail);
	}
	
	
}
