package io.gizmo.kz.telegram.bot.telegrambot.usecase;

import io.gizmo.kz.telegram.bot.telegrambot.model.translator.Word;
import io.gizmo.kz.telegram.bot.telegrambot.translator.Translator;
import org.springframework.stereotype.Component;

@Component
public class TranslateUseCase implements UseCase<TranslateUseCaseRequest, Word> {

    private final Translator translator;

    public TranslateUseCase(Translator translator) {
        this.translator = translator;
    }

    @Override
    public Word execute(TranslateUseCaseRequest translateUseCaseRequest) {
        return translator.translate(translateUseCaseRequest.word, translateUseCaseRequest.lang);
    }
}
