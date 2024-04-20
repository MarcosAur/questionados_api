package com.marcosaur.questionados_api.model.dto.reply;

import com.marcosaur.questionados_api.model.entity.Reply;

public class ReplyDto {

    private Long id;
    private Long question;
    private String text;
    private boolean correct;

    public ReplyDto(Long question, String text, boolean correct, Long id) {
        this.id = id;
        this.question = question;
        this.text = text;
        this.correct = correct;
    }

    public ReplyDto(Reply reply) {
        this.id = reply.getId();
        this.question = reply.getQuestion().getId();
        this.text = reply.getText();
        this.correct = reply.getIsCorrect();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestion() {
        return question;
    }

    public void setQuestion(Long question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
