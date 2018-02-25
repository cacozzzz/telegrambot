package io.gizmo.kz.telegram.bot.telegrambot.core;

import io.gizmo.kz.telegram.bot.telegrambot.gateway.Gateway;
import io.gizmo.kz.telegram.bot.telegrambot.gateway.GatewaySpring;
import io.gizmo.kz.telegram.bot.telegrambot.model.Chat;
import io.gizmo.kz.telegram.bot.telegrambot.model.Message;
import io.gizmo.kz.telegram.bot.telegrambot.model.Update;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BotTest {
    private class GatewaySpy implements Gateway {
        private String message;
        private String updateText = "text";

        @Override
        public List<Update> getUpdates(String url) {
            List<Update> updates = new ArrayList<>();

            Chat chat = new Chat();
            chat.id = 0;

            Message message = new Message();
            message.text = updateText;
            message.chat = chat;

            Update update = new Update();
            update.update_id = 0;
            update.message = message;

            updates.add(update);

            return updates;
        }

        @Override
        public void sendMessage(String url, Map<String, String> message) {
            this.   message = message.get("text");
        }
    }

    Bot bot;
    Gateway gateway;

    @Test
    public void processUpdates() throws Exception {
        bot.processUpdates(bot.getUpdates());
        assertEquals("Answer to text", ((GatewaySpy) gateway).message);
        ((GatewaySpy) gateway).updateText = "/start";
        bot.processUpdates(bot.getUpdates());
        assertEquals("Command was start", ((GatewaySpy)gateway).message);
    }


    @Before
    public void setUp() throws Exception {
        gateway = new GatewaySpy();
        bot = new Bot(gateway);
    }

}