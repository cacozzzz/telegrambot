package io.gizmo.kz.telegram.bot.telegrambot.usecase;

import io.gizmo.kz.telegram.bot.telegrambot.gateway.Gateway;
import io.gizmo.kz.telegram.bot.telegrambot.gateway.GatewaySpring;
import io.gizmo.kz.telegram.bot.telegrambot.translator.InMemoryTranslator;
import io.gizmo.kz.telegram.bot.telegrambot.translator.Translator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SendMessageUseCaseTest {

    private Gateway gateway = new GatewaySpring();
    private Translator translator = new InMemoryTranslator();
    private SendMessageUseCase sendMessageUseCase;


    @Before
    public void setUp() {
        sendMessageUseCase = new SendMessageUseCase(gateway, translator);
    }

    @Test
    public void execute() {
        SendMessageUseCaseRequest caseRequest = new SendMessageUseCaseRequest();
        caseRequest.chatId = 107355595;
        caseRequest.message = "Test from app";
        sendMessageUseCase.execute(caseRequest);
    }
}