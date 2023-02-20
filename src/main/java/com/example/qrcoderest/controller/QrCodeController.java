package com.example.qrcoderest.controller;


import com.example.qrcoderest.dto.QrCodeRequest;
import com.example.qrcoderest.service.QrCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/qr-code")
public class QrCodeController {
    private final QrCodeService qrCodeService;

    @Autowired
    public QrCodeController(QrCodeService qrCodeService){
        this.qrCodeService = qrCodeService;

    }

    @PostMapping("/to-string")
    public ResponseEntity<String> toString(@RequestBody HashMap<String, HashMap<String, String>> map) {
        return ResponseEntity.status(201).body(qrCodeService.convertToString(map));
    }

    @PostMapping()
    public ResponseEntity<HashMap<String, HashMap<String,String>>> toJson2(@RequestBody QrCodeRequest qrCodeRequest) {
        return ResponseEntity.status(201).body(qrCodeService.convertToHashMap(qrCodeRequest));
    }
}
