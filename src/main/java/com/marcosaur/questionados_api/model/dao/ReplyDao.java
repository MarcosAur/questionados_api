package com.marcosaur.questionados_api.model.dao;

import com.marcosaur.questionados_api.model.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyDao extends JpaRepository<Reply, Long> {
}
