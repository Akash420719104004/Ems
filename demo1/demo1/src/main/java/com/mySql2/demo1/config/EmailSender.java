//
//package com.mySql2.demo1.config;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.stereotype.Component;
//
//import java.util.Properties;
//@Component
//@Configuration
//public class EmailSender {
//    @Value("${mail.password}")
//    private String password;
//    @Value("${mail.username}")
//    private String username;
//    @Bean
//    public JavaMailSenderImpl mailSender() {
//        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//        javaMailSender.setHost("mail.coherent.in");
//        javaMailSender.setPort(587);
//        javaMailSender.setUsername(username);
//        javaMailSender.setPassword(password);
//        Properties properties = javaMailSender.getJavaMailProperties();
//        properties.put("mail.transport.protocol", "smtp");
//        properties.put("mail.smtp.auth","true");
//        properties.put("mail.smtp.starttls.enable","true");
//        properties.put("mail.debug","true");
//        return  javaMailSender;
//    }
//}
//