package com.tramasoli.telegram.qatorbot.model.question;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabio on 18/04/17.
 */
@Entity
@Table(name="ChatUser")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();

    @OneToMany(mappedBy = "acceptedBy", cascade = CascadeType.ALL)
    private List<Answer> acceptedAnswers = new ArrayList<>();;

    @OneToMany(mappedBy = "answerer", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();;

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
        return new ArrayList<Question>(questions);
    }

    public void addQuestion(Question question)
    {
        if(questions.contains(question)) {
            return;
        }
        questions.add(question);
        question.setUser(this);
    }

    public void removeQuestion(Question question)
    {
        if(!questions.contains(question)) {
            return;
        }
        questions.remove(question);
        question.setUser(null);
    }

    public List<Answer> getAcceptedAnswers() {
        return new ArrayList<Answer>(acceptedAnswers);
    }

    public void addAcceptedAnswer(Answer acceptedAnswer)
    {
        if(acceptedAnswers.contains(acceptedAnswer)) {
            return;
        }
        acceptedAnswers.add(acceptedAnswer);
        acceptedAnswer.setAcceptedBy(this);
    }

    public void removeAcceptedAnswer(Answer acceptedAnswer)
    {
        if(!acceptedAnswers.contains(acceptedAnswer)) {
            return;
        }
        acceptedAnswers.remove(acceptedAnswer);
        acceptedAnswer.setAcceptedBy(null);
    }

    public List<Answer> getAnswers() {
        return new ArrayList<Answer>(answers);
    }

    public void addAnswer(Answer answer)
    {
        if(answers.contains(answer)) {
            return;
        }
        answers.add(answer);
        answer.setAnswerer(this);
    }

    public void removeAnswer(Answer answer)
    {
        if(!answers.contains(answer)) {
            return;
        }
        answers.remove(answer);
        answer.setAnswerer(null);
    }


}
