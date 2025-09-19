package com.shehzab.ruleengine.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shehzab.ruleengine.mapper.JsonMapper;
import com.shehzab.ruleengine.models.RuleRequestPojo;
import com.shehzab.ruleengine.repository.ClickHouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public int insertRule(String rule) throws JsonProcessingException {
        var obj = jsonMapper.fromJson(rule, RuleRequestPojo.class);
        return clickHouseRepository.insertRule(obj.ruleName, obj.field);
    }
}