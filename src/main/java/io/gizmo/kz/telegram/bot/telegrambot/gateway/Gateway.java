package io.gizmo.kz.telegram.bot.telegrambot.gateway;

import io.gizmo.kz.telegram.bot.telegrambot.model.Message;
import io.gizmo.kz.telegram.bot.telegrambot.model.Update;

import java.util.List;
import java.util.Map;

public interface Gateway {
    List<Update> getUpdates(String url);
    void sendMessage(String url, Map<String,String> message);
}
