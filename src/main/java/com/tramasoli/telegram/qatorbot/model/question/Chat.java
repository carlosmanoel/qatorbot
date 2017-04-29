package com.tramasoli.telegram.qatorbot.model.question;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabio on 27/04/17.
 */
@Entity
public class Chat implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_chat")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long telegramChatId;

    private String name;

    @OneToMany(mappedBy = "chat")//, cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTelegramChatId() {
        return telegramChatId;
    }

    public void setTelegramChatId(long telegramChatId) {
        this.telegramChatId = telegramChatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return new ArrayList<Question>(questions);
    }

    public void addQuestion(Question question)
    {
        if(questions.contains(question)) {
            return;
        }
        questions.add(question);
        question.setChat(this);
    }

    public void removeQuestion(Question question)
    {
        if(!questions.contains(question)) {
            return;
        }
        questions.remove(question);
        question.setChat(null);
    }
}
