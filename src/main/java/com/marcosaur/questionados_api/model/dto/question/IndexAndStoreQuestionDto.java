package com.marcosaur.questionados_api.model.dto.question;

import com.marcosaur.questionados_api.model.dto.reply.ReplyDto;
import com.marcosaur.questionados_api.model.entity.Question;
import jakarta.persistence.OneToMany;

import java.util.List;

public class IndexAndStoreQuestionDto {

    private long id;
    private String name;
    private String description;

    @OneToMany
    private List<ReplyDto> replies;

    public IndexAndStoreQuestionDto(Question question){
        this.name = question.getName();
        this.description = question.getDescription();
        this.id = question.getId();
        this.replies = question.getReplies().stream().map(ReplyDto::new).toList();
    }

    public IndexAndStoreQuestionDto(String name, String description){
        this.name = name;
        this.description = description;
    }

    public List<ReplyDto> getReplies() {
        return replies;
    }

    public void setReplies(List<ReplyDto> replies) {
        this.replies = replies;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
