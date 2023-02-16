package com.example.qrcoderest.controller;


import com.example.qrcoderest.dto.QrCodeRequest;
import com.example.qrcoderest.service.QrCodeService;
import com.example.qrcoderest.service.QrCodeService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/qr-code")
public class QrCodeController {

    private final QrCodeService qrCodeService;
    private final QrCodeService2 qrCodeService2;

    @Autowired
    public QrCodeController(QrCodeService qrCodeService, QrCodeService2 qrCodeService2) {
        this.qrCodeService = qrCodeService;
        this.qrCodeService2 = qrCodeService2;
    }

//    @PostMapping
//    public ResponseEntity<HashMap<String, String>> toJson(@RequestBody QrCodeRequest qrCodeRequest) {
//        return ResponseEntity.status(201).body(qrCodeService.returnToJson(qrCodeRequest));
//    }

    @PostMapping("/to-string")
    public ResponseEntity<String> toString(@RequestBody HashMap<String, String> map) {
        return ResponseEntity.status(201).body(qrCodeService.convertToString(map));
    }

    @PostMapping()
    public ResponseEntity<HashMap<String, String>> toJson2(@RequestBody QrCodeRequest qrCodeRequest) {
        return ResponseEntity.status(201).body(qrCodeService2.convertToHashMap(qrCodeRequest));
    }
}
