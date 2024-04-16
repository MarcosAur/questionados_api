package com.marcosaur.questionados_api.model.dto;

public class UpdateQuestionDto {

    private long id;
    private String name;
    private String description;

    public UpdateQuestionDto(String id, String name, String description) {
        this.id = Long.parseLong(id);
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

}
