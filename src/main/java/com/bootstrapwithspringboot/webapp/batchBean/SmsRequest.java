package com.bootstrapwithspringboot.webapp.batchBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SmsRequest {

    @NotBlank
    private String phoneNumber;
    @NotBlank
    private  String message;
}
