package com.marcosaur.questionados_api.model.dao;

import com.marcosaur.questionados_api.model.entity.Question;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Configurable
public interface QuestionDao extends JpaRepository<Question, Long> {

}
