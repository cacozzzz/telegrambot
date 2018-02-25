package io.gizmo.kz.telegram.bot.telegrambot.model;

public class PreCheckoutQuery {
    public String id;
    public User from;
    public String currency;
    public int total_amount;
    public String invoice_payload;
    public String shipping_option_id;
    public OrderInfo order_info;
}
