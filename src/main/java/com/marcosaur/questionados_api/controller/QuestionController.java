package com.marcosaur.questionados_api.controller;

import com.marcosaur.questionados_api.model.dto.QuestionDto;
import com.marcosaur.questionados_api.model.dto.UpdateQuestionDto;
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
    public ResponseEntity<List<QuestionDto>> findAll(){
        List<QuestionDto> questions = questionService.findAll().stream().map(QuestionDto::new).toList();

        return ResponseEntity.ok().body(questions);
    }

    @GetMapping(value="/find-by-id/")
    public ResponseEntity<QuestionDto> findById(@RequestParam String id){
        QuestionDto question = questionService.findById(id);
        if(question != null){
            return ResponseEntity.ok().body(question);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<QuestionDto> save(@RequestBody QuestionDto question){
        QuestionDto savedQuestion = questionService.save(question);
        return ResponseEntity.ok().body(savedQuestion);
    }

    @PutMapping("/update")
    public ResponseEntity<QuestionDto>  update(@RequestBody UpdateQuestionDto question){
        QuestionDto updatedQuestion = questionService.update(question);

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

}
