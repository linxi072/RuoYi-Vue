package com.ruoyi.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.List;

/**
 * 邮件发送器
 */
@Component
public class MailUtils {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;
    public void sendMimeMail(List<String> toMail, String subject, String text) {
        this.sendMimeMail(toMail, null, null, subject, text, null);
    }

    public void sendMimeMail(List<String> toMail, String subject, String text, List<File> files) {
        this.sendMimeMail(toMail, null, null, subject, text, files);
    }

    public void sendMimeMail(List<String> toMail, List<String> ccMail, String subject, String text, List<File> files) {
       this.sendMimeMail(toMail, ccMail, null, subject, text, files);
    }


    /**
     * * 发送文本/html邮件
     * @param toMail 接收
     * @param ccMail 抄送
     * @param bccMail 密件抄送
     * @param subject 主题
     * @param text 内容
     */
    @Async("threadPoolTaskExecutor")
    public void sendMimeMail(List<String> toMail, List<String> ccMail, List<String> bccMail, String subject, String text, List<File> files) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            message.setFrom(from);
            message.setSubject(subject);
            if (files != null && files.size() > 0) {
                //创建多媒体容器对象
                MimeMultipart multipart = new MimeMultipart();
                for (File f : files) {
                    //创建附件对象
                    MimeBodyPart attachPart = new MimeBodyPart();
                    //本地文件
                    DataHandler df = new DataHandler(new FileDataSource(f));
                    //将本地文件设置到附件对象中
                    attachPart.setDataHandler(df);
                    //设置附件文件名
                    attachPart.setFileName(df.getName());

                    attachPart.attachFile(f);
                    attachPart.saveFile(f);
                    //添加附件
                    multipart.addBodyPart(attachPart);
                }
                //创建邮件正文
                MimeBodyPart bodyPart = new MimeBodyPart();
                //添加邮件类型
                bodyPart.setContent(text,"text/html;charset=UTF-8");
                //内容配置
                bodyPart.setDisposition("----------------内容配置------------------");
                //内容描述
                bodyPart.setDescription("----------------内容描述------------------");
                //添加邮件正文
                multipart.addBodyPart(bodyPart);
                //如果邮件中要添加附件，设置为mixed
                multipart.setSubType("mixed");
                ///添加邮件序言
                multipart.setPreamble("----------------分割线------------------");
                //将多媒体对象设置到邮件对象中
                message.setContent(multipart);
            } else {
                message.setText(text);
            }
            //添加接收
            Address[] toMailList = null;
            if (toMail != null && toMail.size() > 0) {
                toMailList = new InternetAddress[toMail.size()];
                for (int i = 0; i < toMail.size(); i++) {
                    toMailList[i] = new InternetAddress(toMail.get(i));
                }
                //接收
                message.setRecipients(Message.RecipientType.TO, toMailList);
            }

            //添加抄送
            if (ccMail != null && ccMail.size() > 0) {
                toMailList = new InternetAddress[ccMail.size()];
                for (int i = 0; i < ccMail.size(); i++) {
                    toMailList[i] = new InternetAddress(ccMail.get(i));
                }
                //抄送
                message.addRecipients(MimeMessage.RecipientType.CC, toMailList);
            }

            //添加密件抄送
            if (bccMail != null && bccMail.size() > 0) {
                toMailList = new InternetAddress[bccMail.size()];
                for (int i = 0; i < bccMail.size(); i++) {
                    toMailList[i] = new InternetAddress(bccMail.get(i));
                }
                //密件抄送
                message.addRecipients(MimeMessage.RecipientType.BCC, toMailList);
            }

            javaMailSender.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
