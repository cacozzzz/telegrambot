package io.gizmo.kz.telegram.bot.telegrambot.usecase;

import io.gizmo.kz.telegram.bot.telegrambot.model.translator.Word;
import io.gizmo.kz.telegram.bot.telegrambot.translator.InMemoryTranslator;
import io.gizmo.kz.telegram.bot.telegrambot.translator.Translator;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class TranslateUseCaseTest {

    private Translator translator;
    private TranslateUseCase useCase;

    @Before
    public void setUp() {
        translator = new InMemoryTranslator();
        useCase = new TranslateUseCase(translator);

    }

    @Test
    public void execute() throws Exception {
        Word expected = new Word("BMW");
        expected.setLang("De");

        Word word = new Word("asdasd");
        word.setLang("Ru");
        assertEquals(expected, translator.translate(word,"Ru"));
    }

}