package com.example.qrcoderest.repository;

import com.example.qrcoderest.entity.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QrCodeRepository extends JpaRepository<QrCode, Integer> {
}
