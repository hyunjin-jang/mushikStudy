package mushikStudy.com.mushikStudy.util;

import lombok.experimental.UtilityClass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@UtilityClass
public class TranslateUtil {

    public static String translate(String targetText, RestTemplate restTemplate) {
        String url = "https://api.mymemory.translated.net/get?q=" + targetText + "&langpair=ja|ko";
        ResponseEntity<Map> testResponse = restTemplate.getForEntity(url, Map.class);
        Map<String, Object> responseBody = (Map<String, Object>) testResponse.getBody().get("responseData");
        return responseBody.get("translatedText").toString();
    }

    public static String convertKunYomi(String kunYomi, String kanji) {
        if (kunYomi.contains(".")) {
            return kanji + kunYomi.substring(kunYomi.indexOf(".") + 1);
        } else {
            return kanji;
        }
    }
}
