package com.tramasoli.telegram.qatorbot.telegram.commands;


import com.tramasoli.telegram.qatorbot.jpa.DAO;
import com.tramasoli.telegram.qatorbot.model.question.Question;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

import javax.persistence.EntityManager;
import java.util.Arrays;

/**
 * Created by fabio on 24/04/17.
 */
public class QuestionCommand extends BotCommand {

    public QuestionCommand() {
        super("question", "asks a question");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

            BotLogger.info("OK",String.join(" ", Arrays.asList(strings)));
            EntityManager em = DAO.getEntityManager();
            Question question = new Question();
            com.tramasoli.telegram.qatorbot.model.question.User asker = new com.tramasoli.telegram.qatorbot.model.question.User();
            asker.setUsername(user.getUserName());
            asker.setId(user.getId());
            question.setText(String.join(" ", Arrays.asList(strings)));
            question.setUser(asker);
            em.getTransaction().begin();
            em.persist(question);
            em.getTransaction().commit();
            em.close();
            SendMessage message = new SendMessage();
            message.setChatId(chat.getId());
            message.setText("Question ["+question.getText()+"] added! Id: ["+question.getId()+"]");
        try {
            absSender.sendMessage(message);
        } catch (TelegramApiException e) {
            BotLogger.error("OK",e.getStackTrace().toString());
            BotLogger.error("OK",e.getMessage());
        }
    }
}
