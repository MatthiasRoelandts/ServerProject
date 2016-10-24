package com.example.mail;


import freemarker.template.TemplateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by michael on 22/10/2016.
 */

/*
* A mail is send asynchronously so it doesn't slow down the rest call to register a personnel member*/

@Service
public class MailService {


    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @Autowired
    freemarker.template.Configuration freemarkerConfiguration;


    @Async
    public void sendMailToPersonnel(PersonnelMailObj pMailObj) throws AddressException, IOException, TemplateException {


        Map<String,Object> objectMap = new HashMap<String,Object>();
        System.out.println("The name is " + pMailObj.getFirstName());

        objectMap.put("personnel",pMailObj);
        String text = null;
        try {
            //freemarkerConfiguration.setClassForTemplateLoading(this.getClass(),"/templates");
            text = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate("personnel_mail"),objectMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("the mail is" + text);
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
        } catch (Exception e) {
            System.out.println("failed to create mimemessage");
            e.printStackTrace();
        }

        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message,true);
            helper.setTo(pMailObj.getEmail());
            helper.setFrom("ubiquitous10000@gmail.com");
            helper.setSubject("Added as personnel to " + pMailObj.getBusinessName());
            helper.setText(text,true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
