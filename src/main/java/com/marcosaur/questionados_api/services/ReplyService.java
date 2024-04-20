package com.marcosaur.questionados_api.services;

import com.marcosaur.questionados_api.model.dao.ReplyDao;
import com.marcosaur.questionados_api.model.dto.reply.IndexAndStoreReplyDto;
import com.marcosaur.questionados_api.model.entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReplyService {

    @Autowired
    ReplyDao replyDao;

    public List<IndexAndStoreReplyDto> findAll(){
        List<Reply> replysList = replyDao.findAll();
        return replysList.stream().map(IndexAndStoreReplyDto::new).toList();
    }

}
