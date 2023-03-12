package com.springbootpone.NajatSpringbootProjectOne.Mailing.Repositories;

import com.springbootpone.NajatSpringbootProjectOne.Mailing.Models.EmailDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository {

    String sendSimpleMailToMany(EmailDetails emailDetails);
    String sendSimpleMail(EmailDetails emailDetails);
    String sendMailWithAttachmentToMany(EmailDetails emailDetails);
    String sendMailWithAttachment(EmailDetails emailDetails);
}
