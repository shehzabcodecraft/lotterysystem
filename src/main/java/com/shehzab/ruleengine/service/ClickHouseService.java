package com.shehzab.ruleengine.service;

import com.shehzab.ruleengine.mapper.JsonMapper;
import com.shehzab.ruleengine.models.LotteryConfigRequest;
import com.shehzab.ruleengine.repository.ClickHouseRepository;
import com.shehzab.ruleengine.response.LotteryConfigResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ClickHouseService {

    private final ClickHouseRepository clickHouseRepository;
    private final JsonMapper jsonMapper;

    public ClickHouseService(ClickHouseRepository clickHouseRepository, JsonMapper jsonMapper) {
        this.clickHouseRepository = clickHouseRepository;
        this.jsonMapper = jsonMapper;
    }

    public List<Map<String, Object>> runLotteryRule(String generatedSql) {
        return clickHouseRepository.findEligibleCustomers(generatedSql);
    }

    public boolean ping() {
        return clickHouseRepository.ping();
    }

    @Transactional
    public LotteryConfigResponse createLottery(LotteryConfigRequest request) throws Exception {
        UUID lotteryId = UUID.randomUUID();

        //Insert lottery
        clickHouseRepository.insertLottery(lotteryId, request.getName(), request.getStatus());

        //Insert draw config & prize tiers
        UUID drawConfigId = clickHouseRepository.insertDrawConfiguration(lotteryId, request.getDrawConfiguration());
        clickHouseRepository.insertPrizeTiers(drawConfigId, request.getDrawConfiguration().getPrizeConfiguration().getTiers());

        //Insert rules (normal + streak)
        clickHouseRepository.insertRules(lotteryId, request.getRules(), "normal");
        clickHouseRepository.insertRules(lotteryId, request.getStreakRules(), "streak");

        //Insert global rules
        clickHouseRepository.insertGlobalRules(lotteryId, request.getGlobalRules());

        return new LotteryConfigResponse(lotteryId, request.getName(), request.getStatus());
    }


//    private String buildWhereClause(List<LotteryConfigRequest.Condition> conditions) {
//        return conditions.stream()
//                .map(c -> c.getField() + " " + c.getOperator() + " '" + c.getValue() + "'")
//                .collect(Collectors.joining(" AND "));
//    }
}