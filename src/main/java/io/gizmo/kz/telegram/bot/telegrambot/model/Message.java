package io.gizmo.kz.telegram.bot.telegrambot.model;

import java.util.List;

public class Message {
    public int message_id;
    public User from;
    public int date;
    public Chat chat;
    public User forward_from;
    public Chat forward_from_chat;
    public int forward_from_message_id;
    public String forward_signature;
    public int forward_date;
    public Message reply_to_message;
    public int edit_date;
    public String media_group_id;
    public String author_signature;
    public String text;
    public List<MessageEntity> entities;
    public List<MessageEntity> caption_entities;
    public Audio audio;
    public Document document;
    public Game game;
    public List<PhotoSize> photo;
    public Sticker sticker;
    public Video video;
    public Voice voice;
    public VideoNote video_note;
    public String caption;
    public Contact contact;
    public Location location;
    public Venue venue;
    public List<User> new_chat_members;
    public User left_chat_member;
    public String new_chat_title;
    public List<PhotoSize> new_chat_photo;
    public boolean delete_chat_photo;
    public boolean group_chat_created;
    public boolean supergroup_chat_created;
    public boolean channel_chat_created;
    public int migrate_to_chat_id;
    public int migrate_from_chat_id;
    public Message pinned_message;
    public Invoice invoice;
    public SuccessfulPayment successful_payment;
    public String connected_website;
}
