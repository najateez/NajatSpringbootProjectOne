package com.springbootpone.NajatSpringbootProjectOne.controller;

import com.springbootpone.NajatSpringbootProjectOne.Mailing.Models.EmailDetails;
import com.springbootpone.NajatSpringbootProjectOne.Mailing.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping(value = "email")
public class EmailController {

/*  Open your gmail account ->Account-> security -> you will see Signing in to Google,
    in 2-Step verfication make it ON. -> go in search place write app passwords -> in selectApp choose (Mail),
    in selectDevice choose (other Custom name) -> write anything then click generate. exp:Yourpassfhsdjh then click
    generate -> it will generate automatically password -> take generated password andd go to your project
    application.properties, paste the password generated there. and your username will be your gmail.

 */

    @Autowired
    private EmailService emailService;

    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails details) {

        String status = emailService.sendSimpleMail(details);
        return status;
    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails details) {

        String status = emailService.sendMailWithAttachment(details);
        return status;
    }



}
