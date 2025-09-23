package com.shehzab.ruleengine.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shehzab.ruleengine.mapper.JsonMapper;
import com.shehzab.ruleengine.models.LotteryConfigRequest;
import com.shehzab.ruleengine.repository.ClickHouseRepository;
import com.shehzab.ruleengine.response.LotteryConfigResponse;
import com.shehzab.ruleengine.service.ClickHouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RuleEngineController {

    private final ClickHouseService clickHouseService;
    private final JsonMapper jsonMapper;

    public RuleEngineController(ClickHouseService clickHouseService, JsonMapper jsonMapper) {
        this.clickHouseService = clickHouseService;
        this.jsonMapper = jsonMapper;
    }


    @PostMapping("/rule")
    public LotteryConfigResponse saveRule(@RequestBody String lotteryConfigRequest) throws Exception {
        var obj = jsonMapper.fromJson(lotteryConfigRequest, LotteryConfigRequest.class);
        var res = clickHouseService.createLottery(obj);
        return res;
    }
}
