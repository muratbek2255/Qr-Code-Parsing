package com.example.qrcoderest.service;

import com.example.qrcoderest.dto.QrCodeRequest;
import com.example.qrcoderest.entity.QrCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class QrCodeService {

    @Value("${begin.string}")
    private String beginStr;

    public HashMap<String, HashMap<String, String>> convertToHashMap(QrCodeRequest qrCodeRequest) {
        var result = returnList(qrCodeRequest.getQr_code().replace(beginStr, ""));

        HashMap<String, HashMap<String, String>> map = new HashMap<>();

        map.put("1.VersionStandart", new HashMap() {{
            put("1.id", result.get(0).getId());
        }});
        map.get("1.VersionStandart").put("2.len", result.get(0).getLen());
        map.get("1.VersionStandart").put("3.value", result.get(0).getValue());

        map.put("2.TypeOfPayment", new HashMap() {{
            put("1.id", result.get(1).getId());
        }});
        map.get("2.TypeOfPayment").put("2.len", result.get(1).getLen());
        map.get("2.TypeOfPayment").put("3.value", result.get(1).getValue());

        map.put("3.InformationServiceAb", new HashMap() {{
            put("1.id", result.get(2).getId());
        }});
        map.get("3.InformationServiceAb").put("2.len", result.get(2).getLen());
        map.get("3.InformationServiceAb").put("3.value", result.get(2).getValue());

        map.put("4", new HashMap() {{
            put("1.id", result.get(3).getId());
        }});
        map.get("4").put("2.len", result.get(3).getValue());
        map.get("4").put("3.value", result.get(3).getLen());

        map.put("5.InformationAboutMSS", new HashMap() {{
            put("1.id", result.get(4).getId());
        }});
        map.get("5.InformationAboutMSS").put("2.len", result.get(4).getLen());
        map.get("5.InformationAboutMSS").put("3.value", result.get(4).getValue());

        map.put("6.Currency", new HashMap() {{
            put("1.id", result.get(5).getId());
        }});
        map.get("6.Currency").put("2.len", result.get(5).getLen());
        map.get("6.Currency").put("3.value", result.get(5).getValue());

        map.put("7.Sum", new HashMap() {{
            put("1.id", result.get(6).getId());
        }});
        map.get("7.Sum").put("2.len", result.get(6).getLen());
        map.get("7.Sum").put("3.value", result.get(6).getValue());

        map.put("8.ServiceProvider", new HashMap() {{
            put("1.id", result.get(7).getId());
        }});
        map.get("8.ServiceProvider").put("2.len", result.get(7).getValue());
        map.get("8.ServiceProvider").put("3.value", result.get(7).getLen());

        map.put("9.InformationCheckControlSumAbout88", new HashMap() {{
            put("1.id", result.get(8).getId());
        }});
        map.get("9.InformationCheckControlSumAbout88").put("2.len", result.get(8).getValue());
        map.get("9.InformationCheckControlSumAbout88").put("3.value", result.get(8).getLen());

        return map;
    }

    public String convertToString(HashMap<String, HashMap<String, String>> map) {

        String value = beginStr;

        for (Map.Entry<String, HashMap<String, String>> entry: map.entrySet()) {
            String nameOfField = entry.getKey();
            for (Map.Entry<String, String> id_value_entry: entry.getValue().entrySet()) {
                value+=id_value_entry.getValue();
            }
        }
        return value;
    }

    public List<QrCode> returnList(String url_str2) {

        List<QrCode> qrCodeList = new ArrayList<>();

        int yx = 0;

        while (yx < url_str2.length()) {
            var id = url_str2.substring(yx, yx + 2);
            var len_url_str = url_str2.substring(yx + 2, yx + 2 + 2);
            var value_url_str = url_str2.substring(yx + 4, yx + 4 + Integer.parseInt(len_url_str));
            yx = yx + 4 + Integer.parseInt(len_url_str);

            var obj = new QrCode(id, len_url_str, value_url_str);

            qrCodeList.add(obj);

            if (yx > url_str2.length()) {
                break;
            }
        }
        return qrCodeList;
    }
}
