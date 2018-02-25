package io.gizmo.kz.telegram.bot.telegrambot.model;

public class CallbackQuery {
    public String id;
    public User from;
    public Message message;
    public String inline_message_id;
    public String chat_instance;
    public String data;
    public String game_short_name;
}
