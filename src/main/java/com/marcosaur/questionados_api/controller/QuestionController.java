package com.marcosaur.questionados_api.controller;

import com.marcosaur.questionados_api.model.dto.question.IndexAndStoreQuestionDto;
import com.marcosaur.questionados_api.model.dto.question.UpdateQuestionDto;
import com.marcosaur.questionados_api.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(value="/find-all")
    @CrossOrigin
    public ResponseEntity<List<IndexAndStoreQuestionDto>> findAll(){
        List<IndexAndStoreQuestionDto> questions = questionService.findAll();

        return ResponseEntity.ok().body(questions);
    }


    @GetMapping(value="/find-by-id/")
    @CrossOrigin
    public ResponseEntity<IndexAndStoreQuestionDto> findById(@RequestParam String id){
        IndexAndStoreQuestionDto question = questionService.findById(id);
        if(question != null){
            return ResponseEntity.ok().body(question);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<IndexAndStoreQuestionDto> save(@RequestBody IndexAndStoreQuestionDto question){
        IndexAndStoreQuestionDto savedQuestion = questionService.save(question);
        return ResponseEntity.ok().body(savedQuestion);
    }

    @PutMapping("/update")
    public ResponseEntity<IndexAndStoreQuestionDto>  update(@RequestBody UpdateQuestionDto question){
        IndexAndStoreQuestionDto updatedQuestion = questionService.update(question);

        if(updatedQuestion == null){
            return ResponseEntity.badRequest().body(updatedQuestion);
        }else{
            return ResponseEntity.ok().body(updatedQuestion);
        }
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<String> delete(@RequestParam String id){
        boolean deletionSuccefully = questionService.delete(id);

        if (deletionSuccefully){
            return ResponseEntity.status(203).body("Deletado com sucesso");
        }

        return ResponseEntity.unprocessableEntity().body("Registro inexistente");
    };

    @GetMapping(value="/start-game")
    @CrossOrigin
    public ResponseEntity<String> startGame(){
        return null;
    }

}
