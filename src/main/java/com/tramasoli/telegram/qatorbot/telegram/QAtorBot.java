package com.tramasoli.telegram.qatorbot.telegram;

/**
 * Created by fabio on 18/04/17.
 */

import com.tramasoli.telegram.qatorbot.telegram.commands.QuestionCommand;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QAtorBot extends TelegramLongPollingCommandBot {
    private static final String QATORBOT = "qatorbot";
    private static final String QATORBOT_TOKEN = "QATORBOT_TOKEN";
    private static final String DEFAULT_REPLY = "Hey %s is [ %s ] a question??? I can help with that!" +
            "Call me with /help@qatorbot if you need anything!";

    public QAtorBot() {
        register(new QuestionCommand());
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                SendMessage echoMessage = new SendMessage();
                echoMessage.setChatId(message.getChatId());
                echoMessage.setText("Hey heres your message:\n" + message.getText());

                try {
                    sendMessage(echoMessage);
                } catch (TelegramApiException e) {
                    BotLogger.error(QATORBOT, e);
                }
            }
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

    @Override
    public void onClosing() {

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