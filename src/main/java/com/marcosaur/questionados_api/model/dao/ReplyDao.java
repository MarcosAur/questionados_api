package com.marcosaur.questionados_api.model.dao;

import com.marcosaur.questionados_api.model.entity.Question;
import com.marcosaur.questionados_api.model.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyDao extends JpaRepository<Reply, Long> {

    List<Reply> findByQuestion(Question question);

}
