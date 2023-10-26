package com.ruoyi.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 邮件发送器
 */
@Component
public class MailUtils {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;
    @Async("threadPoolTaskExecutor")
    public void sendSimpleMail(String[] toMail, String subject, String text) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(toMail);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        javaMailSender.send(mailMessage);
    }

    @Async("threadPoolTaskExecutor")
    public void sendMimeMail(String[] toMail, String subject, String text) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setFrom(from);
            mimeMessage.setSubject(subject);
            mimeMessage.setText(text);
            InternetAddress[] addresses = new InternetAddress[toMail.length];
            for (int i = 0; i < toMail.length; i++) {
                addresses[i] = new InternetAddress(toMail[i]);
            }
            mimeMessage.addRecipients(Message.RecipientType.CC, addresses);
            Multipart multipart = new MimeMultipart();
            BodyPart bodyPart = new MimeBodyPart();
            multipart.addBodyPart(bodyPart);
            mimeMessage.setContent(multipart);
            javaMailSender.send(mimeMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
