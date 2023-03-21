package com.springbootpone.NajatSpringbootProjectOne.Slack;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SlackClient {

    /* https://api.slack.com/messaging/webhooks -> click create your slack app -> click create an app ->
    click from an app manifest -> select a workplace(codeline slack) -> next -> create -> incoming webhook->
     click ON (Activate Incoming Webhooks) -> add new webhook to workspace -> choose a channel in your slack like
     (general) -> copy Webhook URL ("write Webhooks URL here")
      and put it in code below -> open postman
       -> write this in postman : localhost:8080/slackMessage?text=Hi its me Najateez
     */


    //for Slack Message
    public String sendMessage(String text){
        return WebClient.create().post()
                .uri("https://hooks.slack.com/services/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")//link of channel you want to send text or data api to it.
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackPayLoad(text))
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }
}
