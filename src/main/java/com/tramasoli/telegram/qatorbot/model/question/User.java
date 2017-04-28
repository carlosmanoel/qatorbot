package com.tramasoli.telegram.qatorbot.model.question;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by fabio on 18/04/17.
 */
@Entity
@Table(name="ChatUser")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    private String username;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL})
    private List<Question> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
