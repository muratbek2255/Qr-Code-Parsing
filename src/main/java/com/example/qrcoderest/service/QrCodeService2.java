package com.example.qrcoderest.service;

import com.example.qrcoderest.dto.QrCodeRequest;
import com.example.qrcoderest.entity.QrCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class QrCodeService2 {
    public HashMap<String, String> convertToHashMap(QrCodeRequest qrCodeRequest) {
        var result = returnList(qrCodeRequest.getQr_code());

        HashMap<String, String> map = new HashMap<>();

        map.put("1.VersionStandart", result.get(0).getValue());
//        map.put("3.InformationAboutServiceProvider", result.get(3).getValue());
//        map.put("4.InformationAboutMss", result.get(4).getValue());
//        map.put("5.InformationAboutCurrencyValute", result.get(5).getValue());
//        map.put("6.AmountPayment", result.get(6).getValue());
//        map.put("7.InformationAboutControlSumma", result.get(7).getValue());
        return map;
    }

    public List<QrCode> returnList(String planet2) {

        List<QrCode> qrCodeList = new ArrayList<>();

        int yx = 0;

        if (planet2.startsWith("https://balance.kg/#")) {
            String planet = planet2.replace("https://balance.kg/#", "");
            System.out.println(planet.length());
            while (yx < planet.length()){
                var id = planet.substring(yx, yx + 2);
                var len_planet = planet.substring(yx + 2 , yx + 2 + 2);
                var value_planet = planet.substring(yx + 4, yx + 4 + Integer.parseInt(len_planet));
                System.out.println(value_planet + "value");
                yx = yx + 4 + Integer.parseInt(value_planet);
                System.out.println(yx + "yx");

                var obj = new QrCode(id, value_planet);

                qrCodeList.add(obj);

                if (yx > planet.length()) {
                    break;
                }
                yx++;
            }
        }
        return qrCodeList;
    }
}
