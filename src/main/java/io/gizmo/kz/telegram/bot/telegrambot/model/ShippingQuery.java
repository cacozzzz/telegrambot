package io.gizmo.kz.telegram.bot.telegrambot.model;

public class ShippingQuery {
    public String id;
    public User from;
    public String invoice_payload;
    public ShippingAddress shipping_address;
}
