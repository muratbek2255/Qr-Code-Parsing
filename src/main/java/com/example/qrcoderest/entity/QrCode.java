package com.example.qrcoderest.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "qr_code2", schema = "qr_code_kg")
public class QrCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "name_qr")
    private String value;

    public QrCode(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public QrCode() {

    }
}