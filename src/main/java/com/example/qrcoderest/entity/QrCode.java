package com.example.qrcoderest.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
public class QrCode {

    private String id;

    private String len;

    private String value;

    public QrCode(String id, String len, String value) {
        this.id = id;
        this.len = len;
        this.value = value;
    }

    public QrCode() {

    }
}