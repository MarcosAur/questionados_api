package com.marcosaur.questionados_api.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="questions")
public class Question implements Serializable{
    @Id
    @GeneratedValue
    @Column()
    private long id;

    @Column()
    private String name;

    @Column()
    private String description;


    public Question(){}

    public Question(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Question(String name, String description, Long id) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
