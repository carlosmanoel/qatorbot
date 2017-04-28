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
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fabio on 24/04/17.
 */
public class ListQuestionCommand extends BotCommand {

    public ListQuestionCommand() {
        super("listquestions", "asks a question");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        try {
            BotLogger.info("OK", String.join(" ", Arrays.asList(strings)));
            EntityManager em = DAO.getEntityManager();
            List<Question> questions =
                    em.createQuery("SELECT q FROM Question q WHERE q.chat LIKE :chat")
                            .setParameter("chat", chat.getId())
                            .setMaxResults(10)
                            .getResultList();
            em.close();
            SendMessage message = new SendMessage();
            message.setChatId(chat.getId());
            message.setText("Hello, @" + user.getUserName() + "! We have these questions:\n" +
                    questions.stream().map(a -> a.getText() + "- asked by " + a.getUser().getUsername() + "\n"));

            absSender.sendMessage(message);
        } catch (Exception e) {
            BotLogger.error("OK", e.getStackTrace().toString());
            BotLogger.error("OK", e.getMessage());
        }
    }
}
