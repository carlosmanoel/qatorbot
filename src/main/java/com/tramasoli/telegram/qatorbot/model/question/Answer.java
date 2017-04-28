package com.tramasoli.telegram.qatorbot.model.question;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by fabio on 18/04/17.
 */
@Entity
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_answer")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String text;

    @ManyToOne
    private User acceptedBy;

    @ManyToOne
    private User answerer;

    private boolean accepted = false;

    @NotNull
    @ManyToOne
    private Question question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public User getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(User acceptedBy) {
        this.acceptedBy = acceptedBy;
    }

    public User getAnswerer() {
        return answerer;
    }

    public void setAnswerer(User answerer) {
        this.answerer = answerer;
    }
}
