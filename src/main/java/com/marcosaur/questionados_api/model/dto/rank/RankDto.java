package com.marcosaur.questionados_api.model.dto.rank;

import com.marcosaur.questionados_api.model.entity.Rank;

import java.util.Objects;

public class RankDto {

    private Long id;
    private int points;
    private String name;

    public RankDto(Long id, int points, String name) {
        this.id = id;
        this.points = points;
        this.name = name;
    }

    public RankDto(Rank rank) {
        this.id = rank.getId();
        this.points = rank.getPoints();
        this.name = rank.getName();
    }

    public RankDto() {}

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
        RankDto rankDto = (RankDto) o;
        return points == rankDto.points && Objects.equals(id, rankDto.id) && Objects.equals(name, rankDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, points, name);
    }
}
