package com.tramasoli.telegram.qatorbot.model.question;

import javax.persistence.*;
import java.util.List;

/**
 * Created by fabio on 27/04/17.
 */
@Entity
public class Chat {

    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    private String name;

    @OneToMany(mappedBy = "chat", cascade = {CascadeType.ALL})
    private List<Question> questions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
