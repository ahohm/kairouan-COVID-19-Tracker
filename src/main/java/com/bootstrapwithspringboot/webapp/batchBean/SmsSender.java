package com.bootstrapwithspringboot.webapp.batchBean;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
