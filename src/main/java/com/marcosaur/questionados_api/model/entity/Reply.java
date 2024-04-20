package com.marcosaur.questionados_api.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="replies")
public class Reply {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @ManyToOne
    private Question question;

    @Column
    private String text;

    @Column
    private boolean isCorrect;

    public Reply(Long id, Question question, String text, boolean isCorrect) {
        this.id = id;
        this.question = question;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public Reply() {}

    public Long getId() {
        return this.id;
    }

    public Question getQuestion() {
        return this.question;
    }

    public boolean getIsCorrect() {
        return this.isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public void setQuestionId(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
