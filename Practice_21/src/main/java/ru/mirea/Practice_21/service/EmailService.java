package ru.mirea.Practice_21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${MAIL_FROM:oniwik61@gmail.com}")
    private String mailFrom;
    @Value("${MAIL_TO:oniwik61@gmail.com}")
    private String mailTo;

    @Async
    public void sendSimpleMessage(String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailTo);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}