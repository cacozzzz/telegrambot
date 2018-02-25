package io.gizmo.kz.telegram.bot.telegrambot.usecase;

public interface UseCase<T,R> {
    R execute(T t);
}
