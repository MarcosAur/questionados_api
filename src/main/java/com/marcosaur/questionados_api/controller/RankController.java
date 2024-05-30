package com.marcosaur.questionados_api.controller;

import com.marcosaur.questionados_api.model.dto.rank.RankDto;

import com.marcosaur.questionados_api.services.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/ranks")
public class RankController {

    @Autowired
    private RankService rankService;

    @GetMapping(value = "/find-all")
    @CrossOrigin
    public ResponseEntity<List<RankDto>> findAll() {
        return ResponseEntity.ok().body(rankService.findAll());
    }

    @GetMapping(value = "/find-top-ten")
    @CrossOrigin
    public ResponseEntity<List<RankDto>> findTopTen() {
        return ResponseEntity.ok().body(rankService.findTopTen());
    }

    @GetMapping(value = "/find-position-in-rank/")
    @CrossOrigin
    public ResponseEntity<Object> findPositionInRank(@RequestParam Long id) {

        int position = rankService.getPositionById(id);
        if (position == 0) {
            return ResponseEntity.unprocessableEntity().body("Id inexistente na base de dados");

        } else {
            return ResponseEntity.ok().body(position);
        }


    }

    @PostMapping(value = "/save")
    @CrossOrigin
    public ResponseEntity<Object> store(@RequestBody RankDto rankDto) {

        Map<String, Object> returnedData = rankService.store(rankDto);

        if (returnedData.containsKey("savedRank")) {
            return ResponseEntity.ok().body(returnedData.get("savedRank"));
        } else {
            return ResponseEntity.badRequest().body(returnedData.get("message"));
        }
    }

}
