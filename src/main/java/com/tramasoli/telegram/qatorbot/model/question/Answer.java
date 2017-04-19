package com.tramasoli.telegram.qatorbot.model.question;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by fabio on 18/04/17.
 */
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String text;

    private boolean accepted = false;

    @NotNull
    private Question question;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
}
