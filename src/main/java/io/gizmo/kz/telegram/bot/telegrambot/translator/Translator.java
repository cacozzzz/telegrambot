package io.gizmo.kz.telegram.bot.telegrambot.translator;

import io.gizmo.kz.telegram.bot.telegrambot.model.translator.Word;

public interface Translator {
    Word translate(Word word, String targetLang);
}
