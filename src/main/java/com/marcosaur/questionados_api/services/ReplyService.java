package com.marcosaur.questionados_api.services;

import com.marcosaur.questionados_api.model.dao.QuestionDao;
import com.marcosaur.questionados_api.model.dao.ReplyDao;
import com.marcosaur.questionados_api.model.dto.reply.IndexAndStoreReplyDto;
import com.marcosaur.questionados_api.model.entity.Question;
import com.marcosaur.questionados_api.model.entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReplyService {

    @Autowired
    ReplyDao replyDao;

    @Autowired
    QuestionDao questionDao;

    public List<IndexAndStoreReplyDto> findAll(){
        List<Reply> replysList = replyDao.findAll();
        return replysList.stream().map(IndexAndStoreReplyDto::new).toList();
    }

    public List<IndexAndStoreReplyDto> findByQuestion(long question){
        List<Reply> replies = replyDao.findByQuestion(questionDao.getReferenceById(question));
        return replies.stream().map(IndexAndStoreReplyDto::new).toList();
    }

    public Map<String, Object> store(IndexAndStoreReplyDto reply){
        Reply replyToSave = new Reply();
        Map<String, Object> returnMap = new HashMap<>();

        if (reply.getCorrect()) {
            List<IndexAndStoreReplyDto> replies = this.findByQuestion(reply.getQuestion());
            boolean hasCorrect = false;

            for (IndexAndStoreReplyDto replie : replies) {
                if (replie.getCorrect()) {
                    returnMap.put("message", "Não é possível criar duas questões corretas");
                    return returnMap;
                }
            }
        }

        Question relatedQuestion = questionDao.getReferenceById(reply.getQuestion());
        replyToSave.setText(reply.getText());
        replyToSave.setIsCorrect(reply.getCorrect());
        replyToSave.setQuestionId(relatedQuestion);

        Reply savedReply = replyDao.save(replyToSave);

        returnMap.put("savedReply", new IndexAndStoreReplyDto(savedReply));

        return returnMap;
    }



}
