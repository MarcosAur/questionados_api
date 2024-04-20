package com.marcosaur.questionados_api.model.dto.reply;

import com.marcosaur.questionados_api.model.entity.Reply;

public class IndexAndStoreReplyDto {

    private Long question;
    private String text;
    private boolean correct;

    public IndexAndStoreReplyDto(Long question, String text, boolean correct) {
        this.question = question;
        this.text = text;
        this.correct = correct;
    }

    public IndexAndStoreReplyDto(Reply reply) {
        this.question = reply.getQuestion().getId();
        this.text = reply.getText();
        this.correct = reply.getIsCorrect();
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

    public boolean getCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        correct = correct;
    }
}
