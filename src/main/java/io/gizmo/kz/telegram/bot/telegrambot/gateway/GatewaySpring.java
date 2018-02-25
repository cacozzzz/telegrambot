package io.gizmo.kz.telegram.bot.telegrambot.gateway;

import io.gizmo.kz.telegram.bot.telegrambot.model.Message;
import io.gizmo.kz.telegram.bot.telegrambot.model.Update;
import io.gizmo.kz.telegram.bot.telegrambot.model.UpdateResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class GatewaySpring implements Gateway {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Update> getUpdates(String url) {

        UpdateResponse response = restTemplate.getForObject(url, UpdateResponse.class);

        return response.result;
    }

    @Override
    public void sendMessage(String url, Map<String, String> message) {
        restTemplate.postForObject(url, message, Message.class);
    }

}
