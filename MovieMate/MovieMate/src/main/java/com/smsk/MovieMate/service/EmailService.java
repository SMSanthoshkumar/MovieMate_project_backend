package com.smsk.MovieMate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendWelcomeMail(String toEmail) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("Welcome to MovieMate!");
            message.setText("Thanks for signing up! Enjoy booking your favorite movies.");
            mailSender.send(message);
        } catch (Exception e) {
            // Log error (using your logging framework)
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }
}
