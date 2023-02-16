package com.example.qrcoderest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QrCodeRequest {

    private String qr_code;

    @JsonCreator
    public QrCodeRequest(@JsonProperty("qr_code") String qr_code) {
        this.qr_code = qr_code;
    }
}
