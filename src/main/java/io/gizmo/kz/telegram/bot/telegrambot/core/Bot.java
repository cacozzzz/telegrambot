package io.gizmo.kz.telegram.bot.telegrambot.core;

import io.gizmo.kz.telegram.bot.telegrambot.gateway.Gateway;
import io.gizmo.kz.telegram.bot.telegrambot.model.Update;
import io.gizmo.kz.telegram.bot.telegrambot.model.translator.Word;
import io.gizmo.kz.telegram.bot.telegrambot.translator.Translator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bot {
    private String token;
    private final String apiUrl = "api.telegram.org";

    private int lastUpdateId = 0;

    private Gateway gateway;
    private Translator translator;


    public Bot(String apiKey, Gateway gateway, Translator translator) {
        System.out.println("!!!!!!create bot");
        this.token = apiKey;
        this.gateway = gateway;
        this.translator = translator;
    }


    public List<Update> getUpdates() {
        String command = "getUpdates?offset="+lastUpdateId;
        List<Update> updates = gateway.getUpdates(getFullUrl(apiUrl, token, command));

        if (updates != null && updates.size() > 0) {
            System.out.println("Got updates = " + updates.size());
            updateLastId(updates);
        }

        return updates;
    }

    private void updateLastId(List<Update> updates) {
        lastUpdateId = 1 + updates.stream().max(
                (o1, o2) -> Integer.compare(o2.update_id, o1.update_id)).get().update_id;
    }

    public void processUpdates(List<Update> updates) {
        if (updates == null) return;

        for (Update update : updates) {
            if(update.message == null || update.message.text == null) continue;

            Map<String, String> message = new HashMap<>();
            String answer = giveAnswer(update.message.text);
            message.put("chat_id", String.valueOf(update.message.chat.id));
            message.put("text", answer);
            sendMessage(message);
        }
    }

        private String giveAnswer(String question) {
        if (question.charAt(0) == '/') {
            return "Command was " + question.substring(1);
        } else {

            return translator.translate(new Word(question), "de").getValue();
            //return "Answer to " + question;
        }
    }

    public void updateAndProcess() {
        System.out.println("RUN processAndUpdate");
        System.out.println("lastUpdate = " + lastUpdateId);
        processUpdates(getUpdates());
    }

    public void sendMessage(Map<String, String> message) {
        String command = "sendMessage";
        gateway.sendMessage(getFullUrl(apiUrl, token,command), message);
    }

    private String getFullUrl(String url, String token, String comand) {
        return "https://" + url + "/" + token + "/" + comand;
    }

}
