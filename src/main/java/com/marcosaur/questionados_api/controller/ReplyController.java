package com.marcosaur.questionados_api.controller;

import com.marcosaur.questionados_api.model.dto.reply.ReplyDto;
import com.marcosaur.questionados_api.services.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/replies")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @GetMapping(value="/find-by-question/")
    public ResponseEntity<List<ReplyDto>> findByQuestionId(@RequestParam Long question){
        return ResponseEntity.ok().body(replyService.findByQuestion(question));
    }

    @GetMapping(value="/find-all")
    public ResponseEntity<List<ReplyDto>> findAll(){
        return ResponseEntity.ok().body(replyService.findAll());
    }

    @PostMapping(value="/store")
    public ResponseEntity<Object> store(@RequestBody ReplyDto reply){
        Map<String, Object> returnMap = replyService.store(reply);

        if (returnMap.containsKey("savedReply")){
            return ResponseEntity.ok().body(returnMap.get("savedReply"));
        } else {
            return ResponseEntity.unprocessableEntity().body(returnMap.get("message"));
        }

    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody ReplyDto reply){

        Map<String, Object> returnMap = replyService.update(reply);

        if (returnMap.containsKey("savedReply")){
            return ResponseEntity.ok().body(returnMap.get("savedReply"));
        } else {
            return ResponseEntity.unprocessableEntity().body(returnMap.get("message"));
        }
    }

}
