package com.springbootpone.NajatSpringbootProjectOne.Mailing.Services;

import com.springbootpone.NajatSpringbootProjectOne.Mailing.Models.EmailDetails;
import com.springbootpone.NajatSpringbootProjectOne.Mailing.Repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

// import for email
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
public class EmailService implements EmailRepository {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")  //from application.properties, from that email.

    private String sender;

    @Override
    public String sendSimpleMailToMany(EmailDetails emailDetails){

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            List<String> mailingList = emailDetails.getRecipient();
            for (String email : mailingList) {
                // Setting up necessary details
                mailMessage.setFrom(sender);
                mailMessage.setTo(email);
                mailMessage.setText(emailDetails.getMsgBody());
                mailMessage.setSubject(emailDetails.getSubject());

                // Sending the mail
                mailSender.send(mailMessage);
            }

            return "Mail Sent Successfully...";
        }

// Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    //code for sending Attachments. exp: pdf,.. etc
    @Override
    public String sendMailWithAttachmentToMany(EmailDetails emailDetails) {

        // Creating a mime message
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper; //help for covert to string, like before we did createdDate from date to string same idea

        try {
            List<String> mailingList = emailDetails.getRecipient();

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);  //here used constructor
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setText(emailDetails.getMsgBody());
            mimeMessageHelper.setSubject(emailDetails.getSubject());

            // Adding the attachment
            FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);

            // Sending the mail
            for (String email : mailingList) {
                mimeMessageHelper.setTo(email); //emails you to send to
                mailSender.send(mimeMessage);
            }

            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }

    @Override
    public String sendSimpleMail(EmailDetails emailDetails) {
        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage= new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(emailDetails.getRecipient().get(0));
            mailMessage.setText(emailDetails.getMsgBody());
            mailMessage.setSubject(emailDetails.getSubject());

            // Sending the mail
            mailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }

    }

    @Override
    public String sendMailWithAttachment(EmailDetails emailDetails) {
        // Creating a mime message
        MimeMessage mimeMessage= mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper= new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(emailDetails.getRecipient().get(0));
            mimeMessageHelper.setText(emailDetails.getMsgBody());
            mimeMessageHelper.setSubject(emailDetails.getSubject());

            // Adding the attachment
            FileSystemResource file= new FileSystemResource(new File(emailDetails.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);

            // Sending the mail
            mailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail!!!";
        }

    }


}
