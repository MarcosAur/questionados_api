package com.marcosaur.questionados_api.model.dao;

import com.marcosaur.questionados_api.model.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RankDao extends JpaRepository<Rank, Long> {
    @Query("SELECT r FROM Rank r ORDER BY r.points DESC LIMIT 10")
    List<Rank> findTopTen();

    @Query("SELECT r FROM Rank r ORDER BY r.points DESC")
    List<Rank> findAllOrderByPointsDesc();
}
