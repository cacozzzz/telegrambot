package io.gizmo.kz.telegram.bot.telegrambot.controller;

import io.gizmo.kz.telegram.bot.telegrambot.core.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    Bot bot;

    @GetMapping
    public @ResponseBody String update() {
        StringBuilder stringBuilder = new StringBuilder();

        bot.getUpdates().forEach((u) -> stringBuilder.append(u.toString()));


        return stringBuilder.toString();

    }
}
