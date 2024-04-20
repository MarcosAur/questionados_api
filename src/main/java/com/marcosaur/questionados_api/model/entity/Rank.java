package com.marcosaur.questionados_api.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Table(name="ranks")
@Entity
public class Rank {

    @GeneratedValue
    @Id
    private Long id;

    @Column
    private int points;

    @Column
    private String name;

    public Rank(int points, String name) {
        this.points = points;
        this.name = name;
    }


    public Rank(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank = (Rank) o;
        return points == rank.points && Objects.equals(id, rank.id) && Objects.equals(name, rank.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, points, name);
    }
}
