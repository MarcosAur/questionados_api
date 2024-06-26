package com.marcosaur.questionados_api.services;

import com.marcosaur.questionados_api.model.dao.QuestionDao;
import com.marcosaur.questionados_api.model.dao.ReplyDao;
import com.marcosaur.questionados_api.model.dto.question.IndexAndStoreQuestionDto;
import com.marcosaur.questionados_api.model.dto.question.UpdateQuestionDto;
import com.marcosaur.questionados_api.model.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private ReplyDao replyDao;

    public List<IndexAndStoreQuestionDto> findAll(){

        List<Question> questions = questionDao.findAll();

        for (Question question : questions) {
            question.setReplies(replyDao.findByQuestion(question));
        }

        return questions.stream()
                .map(IndexAndStoreQuestionDto::new)
                .toList();
    }

    public IndexAndStoreQuestionDto findById(String id){
        Optional<Question> question = questionDao.findById(Long.parseLong(id));

        if (question.isPresent()) {

            return new IndexAndStoreQuestionDto(question.get());
        }

        return null;
    }


    public IndexAndStoreQuestionDto save(IndexAndStoreQuestionDto questionDto){
        Question question = new Question(questionDto.getName(), questionDto.getDescription());
        Question savedQuestion = questionDao.save(question);

        return new IndexAndStoreQuestionDto(savedQuestion);
    }

    public IndexAndStoreQuestionDto update(UpdateQuestionDto questionDto){
        IndexAndStoreQuestionDto updatedQuestion;

        if(questionDao.findById(questionDto.getId()).isPresent()){
            Question questionToUpdate = new Question(questionDto.getName(), questionDto.getDescription(), questionDto.getId());
            updatedQuestion = new IndexAndStoreQuestionDto(questionDao.saveAndFlush(questionToUpdate));
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
