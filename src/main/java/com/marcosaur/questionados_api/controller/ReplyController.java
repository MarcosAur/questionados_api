package com.marcosaur.questionados_api.controller;

import com.marcosaur.questionados_api.model.dto.reply.IndexAndStoreReplyDto;
import com.marcosaur.questionados_api.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/replies")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @GetMapping(value="/find-by-question/")
    public List<IndexAndStoreReplyDto> findByQuestionId(@RequestParam Long question){
        return replyService.findByQuestion(question);
    }

    @GetMapping(value="/find-all")
    public List<IndexAndStoreReplyDto> findAll(){
        return replyService.findAll();
    }

    @PostMapping(value="/store")
    public ResponseEntity store(@RequestBody IndexAndStoreReplyDto reply){
        Map<String, Object> returnMap = replyService.store(reply);

        if (returnMap.containsKey("savedReply")){
            return ResponseEntity.ok().body(returnMap.get("savedReply"));
        } else {
            return ResponseEntity.unprocessableEntity().body(returnMap.get("message"));
        }


    }

}
