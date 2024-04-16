package com.marcosaur.questionados_api.controller;

import com.marcosaur.questionados_api.model.entity.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/questions")
public class QuestionController {

    @GetMapping(value="/find-all")
    public List<Question> findAll(){
        List<Question> questions = new ArrayList<>();

        Question question1 = new Question("Teste 1", "Esta é a primeira pergunta");
        Question question2 = new Question();
        question2.setName("Teste 2");
        question2.setDescription("Esta é a primeira pergunta");

        questions.add(question1);
        questions.add(question2);

        return questions;
    }

}
