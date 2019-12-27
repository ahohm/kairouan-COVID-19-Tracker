package com.bootstrapwithspringboot.webapp.batchBean;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class SmsCtrl {

    private final Service service;

    private  SmsSender smsSender;

    @PostMapping("/api/v1/sms")
    public String sendSms( SmsRequest smsRequest){
        System.out.println(smsRequest.getPhoneNumber());
        System.out.println(smsRequest.getMessage());


        service.sendSms(smsRequest);
        return "pageSms";
    }

}
