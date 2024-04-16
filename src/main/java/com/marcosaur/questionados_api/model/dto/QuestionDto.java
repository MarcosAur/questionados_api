package com.marcosaur.questionados_api.model.dto;

import com.marcosaur.questionados_api.model.entity.Question;

public class QuestionDto {

    private long id;
    private String name;
    private String description;

    public QuestionDto(Question question){
        this.name = question.getName();
        this.description = question.getDescription();
        this.id = question.getId();
    }

    public QuestionDto(String name, String description){
        this.name = name;
        this.description = description;
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
