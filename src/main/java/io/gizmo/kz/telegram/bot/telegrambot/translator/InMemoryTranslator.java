package io.gizmo.kz.telegram.bot.telegrambot.translator;

import io.gizmo.kz.telegram.bot.telegrambot.model.translator.Word;
import org.springframework.stereotype.Component;

@Component
public class InMemoryTranslator implements Translator {
    @Override
    public Word translate(Word word, String targetLang) {
        Word res = new Word();
        res.setLang("De");
        res.setValue("BMW");
        return res;
    }
}
