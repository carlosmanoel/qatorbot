package com.tramasoli.telegram.qatorbot.telegram;

/**
 * Created by fabio on 18/04/17.
 */

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class QAtorBot extends TelegramLongPollingBot {

    private static final String QATORBOT = "qatorbot";
    private static final String QATORBOT_TOKEN = "QATORBOT_TOKEN";

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId())
                    .setText(update.getMessage().getText());
            try {
                sendMessage(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return QATORBOT;
    }

    public String getBotToken() {
        return System.getenv(QATORBOT_TOKEN);
    }
}