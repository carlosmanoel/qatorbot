package com.tramasoli.telegram.qatorbot.model.question;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by fabio on 18/04/17.
 */
@Entity
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_question")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String text;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    @ManyToOne
    private Chat chat;

    public Question() {
        this.answers = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public boolean isAnswered() {
        return getAnswers().stream().anyMatch(a -> a.isAccepted());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (!getText().equals(question.getText())) return false;
        return getAnswers() != null ? getAnswers().equals(question.getAnswers()) : question.getAnswers() == null;
    }

    @Override
    public int hashCode() {
        int result = getText().hashCode();
        result = 31 * result + (getAnswers() != null ? getAnswers().hashCode() : 0);
        return result;
    }
}
