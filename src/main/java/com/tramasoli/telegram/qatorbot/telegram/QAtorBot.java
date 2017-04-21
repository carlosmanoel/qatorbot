package com.tramasoli.telegram.qatorbot.telegram;

/**
 * Created by fabio on 18/04/17.
 */

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.logging.Logger;

public class QAtorBot extends TelegramLongPollingBot {

    private static final Logger LOGGER = Logger.getLogger(QAtorBot.class.getCanonicalName());
    private static final String QATORBOT = "qatorbot";
    private static final String QATORBOT_TOKEN = "QATORBOT_TOKEN";
    private static final String DEFAULT_REPLY = "Hey %s is [ %s ] a question??? I can help with that!" +
            "Call me with /help@qaterbot if you need anything!";

    public void onUpdateReceived(Update update) {
        LOGGER.info(update.toString());
        if (update.hasMessage() && update.getMessage().hasText()) {
            /*
            if (update.getMessage().getChat().isGroupChat() && update.getMessage().getText().contains("?")) {
                reply(update.getMessage().getChatId()
                        ,String.format(DEFAULT_REPLY
                        , update.getMessage().getFrom().getUserName()
                        , update.getMessage().getText()));
            }
            else if (update.getMessage().getChat().isUserChat()) {
                reply(update.getMessage().getChatId(), update.getMessage().getText());
            }
            */
        }
    }

    @Override
    public String getBotUsername() {
        return QATORBOT;
    }

    @Override
    public String getBotToken() {
        return System.getenv(QATORBOT_TOKEN);
    }

    private void reply(Long chatId, String reply) {
        SendMessage message = new SendMessage()
                .setChatId(chatId)
                .setText(reply);
        try {
            sendMessage(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}