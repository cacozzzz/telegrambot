package io.gizmo.kz.telegram.bot.telegrambot.translator;

import io.gizmo.kz.telegram.bot.telegrambot.gateway.TranslatorGateway;
import io.gizmo.kz.telegram.bot.telegrambot.model.translator.Word;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/*
*  API https://tech.yandex.ru/translate/doc/dg/reference/translate-docpage/
* */
public class YandexTranslator implements Translator {

    private final String API_KEY;
    private static final String URL = "https://translate.yandex.net/api/v1.5/tr.json/";

    public YandexTranslator(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    private enum Commands {
        TRANSLATE("translate"),
        DETECT("detect");

        private String value;

        Commands(String value) {
            this.value = value;
        }
    }

    TranslatorGateway gateway;

    public void setToken(String token) {

    }

    @Override
    public Word translate(Word word, String targetLang) {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> map = restTemplate.getForObject(URL + Commands.TRANSLATE.value + "?key=" + API_KEY + "&text=" + word.getValue() + "&lang=de", Map.class);

        System.out.println(map);

        Word res = new Word(((List<String>) map.get("text")).get(0));
        word.setLang((String)map.get("lang"));
        return res;
    }
}
