package com.example.qrcoderest.service;

import com.example.qrcoderest.dto.QrCodeRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.stream.Collectors;


@Service
public class QrCodeService {

    HashMap<String, String> map = new HashMap<>();

    public HashMap<String, String> returnToJson(QrCodeRequest qrCodeRequest) {;
        if(qrCodeRequest.getQr_code().startsWith("https://balance.kg/#")) {
            String planet = qrCodeRequest.getQr_code().replace("https://balance.kg/#", "");
            System.out.println(planet);
            System.out.println(planet.length());
            for (int i = 0; i < planet.length() - (planet.length() - 7); i++) {
                var id_str = planet.substring(i, i + 2);
                var len_str = planet.substring(i + 2, i + 2 + 2);
                System.out.println(len_str);
                var sal_str = planet.substring(i + 4, i + 4 + Integer.parseInt(len_str));
                var shift = id_str.length() + len_str.length() + sal_str.length();
                i = shift;
                System.out.println(sal_str);
                map.put("1.VersionStandart", sal_str);

                var id_str2 = planet.substring(i + 2, i + 4);
                var len_str2 = planet.substring(i + 2, i + 2 + 2);
                var sal_str2 = planet.substring(i + 4, i + 4 + Integer.parseInt(len_str2));
                System.out.println(sal_str2);
                map.put("2.TypeOfPayment", sal_str2);

                var id_str3 = planet.substring(i + 6, i + 8);
                var len_str3 = planet.substring(i + 2, i + 2 + 2);
                var sal_str3 = planet.substring(i + 14, i + 22 + Integer.parseInt(len_str3));
                map.put("3.InformationAboutServiceProvider", sal_str3);

                var id_str4 = planet.substring(i + 24, i + 26);
                var len_str4 = planet.substring(i + 2, i + 2 + 2);
                var sal_str4 = planet.substring(i + 51, i + 53 + Integer.parseInt(len_str4));
                map.put("4.InformationAboutMss", sal_str4);

                var id_str5 = planet.substring(i + 52, i + 54);
                var len_str5 = planet.substring(i + 2, i + 2 + 2);
                var sal_str5 = planet.substring(i + 59, i + 60 + Integer.parseInt(len_str5));
                System.out.println(sal_str5);
                map.put("5.InformationAboutCurrencyValute", sal_str5);

                var id_str6 = planet.substring(i + 61, i + 63);
                var len_str6 = planet.substring(i + 2, i + 2 + 2);
                var sal_str6 = planet.substring(i + 66, i + 70 + Integer.parseInt(len_str6));
                System.out.println(sal_str6);
                map.put("6.AmountPayment", sal_str6);

                var id_str7 = planet.substring(i + 71, i + 73);
                var len_str7 = planet.substring(i + 2, i + 2 + 2);
                var sal_str7 = planet.substring(i + 90, i + 92 + Integer.parseInt(len_str7));
                map.put("7.InformationAboutControlSumma", sal_str7);
            }
        }
        return map;
    }

    public String convertToString(HashMap<String, String> map) {
        String value1 = map.get("Name usligi");
        String value2 = map.get("VersionStandart");
        String value3 = map.get("Summa");
        String value4 = map.get("InformationAboutPostavshikaUslug");
        String value5 = map.get("MSS");
        String value6 = map.get("TypeOfPayment");
        String value7 = map.get("Control sum");

        String s = "https://balance.kg/#" + value1 + value2 + value3 + value4 + value5 + value6 + value7;

        return s;
    }
}
