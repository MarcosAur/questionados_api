package com.marcosaur.questionados_api.services;

import com.marcosaur.questionados_api.model.dao.RankDao;
import com.marcosaur.questionados_api.model.dto.rank.RankDto;
import com.marcosaur.questionados_api.model.entity.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RankService {

    @Autowired
    RankDao rankDao;

    public List<RankDto> findAll(){
        List<Rank> ranks = rankDao.findAll();

        return ranks.stream().map(RankDto::new).toList();
    }

    public List<RankDto> findTopTen(){
        List<Rank> ranks = rankDao.findTopTen();

        return ranks.stream().map(RankDto::new).toList();
    }

    public Map<String, Object> store (RankDto rank){
        Map<String, Object> returnMap = new HashMap<>();
        try{
            Rank rankToSave = new Rank();

            rankToSave.setName(rank.getName());
            rankToSave.setPoints(rank.getPoints());

            returnMap.put("savedRank", new RankDto(rankDao.save(rankToSave)));
            return returnMap;
        }catch (Exception e){
            returnMap.put("message", "Erro ao salvar rank");
            return returnMap;
        }

    }

    public Integer getPositionById(Long id){
        Optional<Rank> rankById = rankDao.findById(id);

        if(rankById.isEmpty()){
            return 0;
        }

        int position = 1;
        RankDto rankToSearch = new RankDto(rankById.get());
        List<RankDto> ranks = rankDao.findAllOrderByPointsDesc().stream().map(RankDto::new).toList();

        for (RankDto rank : ranks){
            if (rank.equals(rankToSearch)){
                return position;
            } else {
                position += 1;
            }
        }

        return position;
    }
}
