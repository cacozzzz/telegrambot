package io.gizmo.kz.telegram.bot.telegrambot.model;

import java.util.List;

public class Game {
    String title;
    String description;
    List<PhotoSize> photo;
    String text;
    List<MessageEntity> text_entities;
    Animation animation;
}
