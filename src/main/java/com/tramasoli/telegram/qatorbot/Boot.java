package com.tramasoli.telegram.qatorbot;

import com.tramasoli.telegram.qatorbot.telegram.QAtorBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by fabio on 18/04/17.
 */
public class Boot {
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new QAtorBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
