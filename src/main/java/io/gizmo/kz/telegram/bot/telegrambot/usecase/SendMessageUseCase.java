package io.gizmo.kz.telegram.bot.telegrambot.usecase;

import io.gizmo.kz.telegram.bot.telegrambot.core.Bot;
import io.gizmo.kz.telegram.bot.telegrambot.gateway.Gateway;
import io.gizmo.kz.telegram.bot.telegrambot.translator.Translator;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

public class SendMessageUseCase implements UseCase<SendMessageUseCaseRequest, Void> {

    private final Gateway gateway;
    private final Translator translator;

    public SendMessageUseCase(Gateway gateway, Translator translator) {
        this.translator = translator;
        this.gateway = gateway;
    }

    @Override
    public Void execute(SendMessageUseCaseRequest sendMessageUseCaseRequest) {
        Map<String, String> message = new HashMap<>();
        message.put("chat_id", String.valueOf(sendMessageUseCaseRequest.chatId));
        message.put("text", sendMessageUseCaseRequest.message);

        Bot bot = new Bot(System.getenv("telegramApiToken"), gateway, translator);
        bot.sendMessage(message);
        return null;
    }

}
