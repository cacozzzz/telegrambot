package io.gizmo.kz.telegram.bot.telegrambot;

import io.gizmo.kz.telegram.bot.telegrambot.core.Bot;
import io.gizmo.kz.telegram.bot.telegrambot.gateway.Gateway;
import io.gizmo.kz.telegram.bot.telegrambot.gateway.GatewaySpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class TelegrambotApplication {

	@Autowired
	Bot bot;

	@Bean
	Gateway getGatewaySpring() {return new GatewaySpring();}

	@Bean
	Bot getBot(Gateway gateway) {
		return new Bot(gateway);
	}



	@PostConstruct
	public void runBot() {
		ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
		executorService.scheduleAtFixedRate(bot::updateAndProcess, 0, 1, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {
		SpringApplication.run(TelegrambotApplication.class, args);
	}
}
