package com.tramasoli.telegram.qatorbot.model.question;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by fabio on 18/04/17.
 */
@Entity
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_answer")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;

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
}
