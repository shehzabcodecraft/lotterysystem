package com.shehzab.ruleengine.service;

import com.shehzab.ruleengine.repository.ClickHouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ClickHouseService {

    private final ClickHouseRepository clickHouseRepository;

    public ClickHouseService(ClickHouseRepository clickHouseRepository) {
        this.clickHouseRepository = clickHouseRepository;
    }

    public List<Map<String, Object>> runLotteryRule(String generatedSql) {
        return clickHouseRepository.findEligibleCustomers(generatedSql);
    }

    public boolean ping() {
        return clickHouseRepository.ping();
    }
}