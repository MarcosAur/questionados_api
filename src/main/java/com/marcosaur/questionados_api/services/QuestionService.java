package com.marcosaur.questionados_api.services;

import com.marcosaur.questionados_api.model.dao.QuestionDao;
import com.marcosaur.questionados_api.model.dto.QuestionDto;
import com.marcosaur.questionados_api.model.dto.UpdateQuestionDto;
import com.marcosaur.questionados_api.model.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public List<Question> findAll(){
        return questionDao.findAll();
    }

    public QuestionDto findById(String id){
        Optional<Question> question = questionDao.findById(Long.parseLong(id));

        if (question.isPresent()) {

            return new QuestionDto(question.get());
        }

        return null;
    }


    public QuestionDto save(QuestionDto questionDto){
        Question question = new Question(questionDto.getName(), questionDto.getDescription());
        Question savedQuestion = questionDao.save(question);

        return new QuestionDto(savedQuestion);
    }

    public QuestionDto update(UpdateQuestionDto questionDto){
        QuestionDto updatedQuestion;

        if(questionDao.findById(questionDto.getId()).isPresent()){
            Question questionToUpdate = new Question(questionDto.getName(), questionDto.getDescription(), questionDto.getId());
            updatedQuestion = new QuestionDto(questionDao.saveAndFlush(questionToUpdate));
        } else {
            updatedQuestion = null;
        }
        return updatedQuestion;
    }

    public boolean delete(String id){
        Optional<Question> questionToDelete = questionDao.findById(Long.parseLong(id));
        if(questionToDelete.isPresent()){
            questionDao.delete(questionToDelete.get());
            return true;
        } else {
            return false;
        }
    }
}
