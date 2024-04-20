package com.marcosaur.questionados_api.model.dto.reply;

import com.marcosaur.questionados_api.model.entity.Question;
import com.marcosaur.questionados_api.model.entity.Reply;

public class IndexAndStoreReplyDto {

    private Question question;
    private String text;
    private boolean isCorrect;

    public IndexAndStoreReplyDto(Question question, String text, boolean isCorrect) {
        this.question = question;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public IndexAndStoreReplyDto(Reply reply) {
        this.question = reply.getQuestion();
        this.text = reply.getText();
        this.isCorrect = reply.getIsCorrect();
    }

    public IndexAndStoreReplyDto(){}

    public Question getquestion() {
        return question;
    }

    public void setquestion(Question question) {
        this.question = question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
