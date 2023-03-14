package com.springbootpone.NajatSpringbootProjectOne.Slack;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class SlackPayLoad {

    //for Slack Message
    private String text;

    public SlackPayLoad(String text) {
        this.text = text;
    }
}
