package com.springbootpone.NajatSpringbootProjectOne.Mailing.Models;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmailDetails {

    private List<String> recipient; //for how many people you want them to recieve your email
    private String msgBody;
    private String subject;
    private String attachment;


}
