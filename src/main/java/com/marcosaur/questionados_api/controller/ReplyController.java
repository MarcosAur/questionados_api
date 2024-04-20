package com.marcosaur.questionados_api.controller;

import com.marcosaur.questionados_api.model.dto.reply.IndexAndStoreReplyDto;
import com.marcosaur.questionados_api.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/replies")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @GetMapping(value="/find-all")
    public List<IndexAndStoreReplyDto> findAll(){
        return replyService.findAll();
    }

}
