package io.gizmo.kz.telegram.bot.telegrambot;

import io.gizmo.kz.telegram.bot.telegrambot.core.Bot;
import io.gizmo.kz.telegram.bot.telegrambot.gateway.Gateway;
import io.gizmo.kz.telegram.bot.telegrambot.gateway.GatewaySpring;
import io.gizmo.kz.telegram.bot.telegrambot.translator.Translator;
import io.gizmo.kz.telegram.bot.telegrambot.translator.YandexTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class TelegrambotApplication {

	private static String yandexApiKey;
	private static String telegramApiKey;

	@Autowired
	Bot bot;

	@Bean
	Translator getYandexTranslator() {return new YandexTranslator(System.getenv("yandexApiKey"));}

	@Bean
	Gateway getGatewaySpring() {return new GatewaySpring();}

	@Bean
	Bot getBot(Gateway gateway, Translator translator) {
		return new Bot(System.getenv("telegramApiKey"), gateway, translator);
	}


	@PostConstruct
	public void runBot() {
		ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
		executorService.scheduleAtFixedRate(bot::updateAndProcess, 0, 1, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {

		parseArgs(args);
		SpringApplication.run(TelegrambotApplication.class, args);
	}

	private static void parseArgs(String[] args) {
		for (String arg : args) {
			if (arg.toLowerCase().contains("--yandex=")) {
				yandexApiKey = arg.substring("--yandex=".length());
			} else if (arg.contains("--telegram=")) {
				telegramApiKey = arg.substring("--telegram=".length());
			}
		}

	}
}
