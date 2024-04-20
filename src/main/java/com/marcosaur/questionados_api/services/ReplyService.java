package com.marcosaur.questionados_api.services;

import com.marcosaur.questionados_api.model.dao.QuestionDao;
import com.marcosaur.questionados_api.model.dao.ReplyDao;
import com.marcosaur.questionados_api.model.dto.reply.ReplyDto;
import com.marcosaur.questionados_api.model.entity.Question;
import com.marcosaur.questionados_api.model.entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReplyService {

    @Autowired
    ReplyDao replyDao;

    @Autowired
    QuestionDao questionDao;

    public List<ReplyDto> findAll(){
        List<Reply> replysList = replyDao.findAll();
        return replysList.stream().map(ReplyDto::new).toList();
    }

    public List<ReplyDto> findByQuestion(long question){
        List<Reply> replies = replyDao.findByQuestion(questionDao.getReferenceById(question));
        return replies.stream().map(ReplyDto::new).toList();
    }

    public Map<String, Object> store(ReplyDto reply){
        Map<String, Object> returnMap = new HashMap<>();
        try{
            Reply replyToSave = new Reply();

            if (reply.isCorrect()) {
                List<ReplyDto> replies = this.findByQuestion(reply.getQuestion());

                for (ReplyDto replyInList : replies) {
                    if (replyInList.isCorrect()) {
                        returnMap.put("message", "Não é possível criar duas questões corretas");
                        return returnMap;
                    }
                }
            }

            Question relatedQuestion = questionDao.getReferenceById(reply.getQuestion());
            replyToSave.setText(reply.getText());
            replyToSave.setIsCorrect(reply.isCorrect());
            replyToSave.setQuestionId(relatedQuestion);

            Reply savedReply = replyDao.save(replyToSave);

            returnMap.put("savedReply", new ReplyDto(savedReply));

            return returnMap;
        } catch (Exception e){
            returnMap.put("message", "Erro desconhecido ao salvar resposta");
            return returnMap;
        }
    }

    public Map<String, Object> update(ReplyDto reply){
        Map<String, Object> returnMap = new HashMap<>();

        try{
            if (reply.isCorrect()){
                List<ReplyDto> replies = this.findByQuestion(reply.getQuestion());

                for (ReplyDto replyInList : replies) {
                    if (replyInList.isCorrect() && replyInList.getId() != reply.getId()) {
                        returnMap.put("message", "Não é possível criar duas questões corretas");
                        return returnMap;
                    }
                }
            }
            Reply replyToUpdate = new Reply();

            Question question = questionDao.getReferenceById(reply.getQuestion());

            replyToUpdate.setId(reply.getId());
            replyToUpdate.setText(reply.getText());
            replyToUpdate.setIsCorrect(reply.isCorrect());
            replyToUpdate.setQuestionId(question);

            ReplyDto updatedReply = new ReplyDto(replyDao.saveAndFlush(replyToUpdate));

            returnMap.put("savedReply", updatedReply);

            return returnMap;

        } catch (Exception e){
            returnMap.put("message", "Erro desconhecido ao salvar resposta");
            return returnMap;
        }
    }
}
