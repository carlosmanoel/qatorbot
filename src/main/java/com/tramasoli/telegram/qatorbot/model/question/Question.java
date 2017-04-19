package com.tramasoli.telegram.qatorbot.model.question;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by fabio on 18/04/17.
 */
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String text;
    private List<Answer> answers;

    public Question() {
        this.answers = new ArrayList<>();
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

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public boolean isAnswered() {
        Predicate<Answer> correct = a -> a.isAccepted();
        return getAnswers().stream().anyMatch(correct);
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
