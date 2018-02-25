package io.gizmo.kz.telegram.bot.telegrambot.model;

public class Update {
    public int update_id;
    public Message message;
    public Message edited_message;
    public Message channel_post;
    public Message edited_channel_post;
    public InlineQuery inline_query;
    public ChosenInlineResult chosen_inline_result;
    public CallbackQuery callback_query;
    public ShippingQuery shipping_query;
    public PreCheckoutQuery pre_checkout_query;

    @Override
    public String toString() {
        return "Update{" +
                "update_id=" + update_id +
                ", message=" + message.text +
                '}';
    }
}
