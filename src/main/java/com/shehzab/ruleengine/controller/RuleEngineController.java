package com.shehzab.ruleengine.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shehzab.ruleengine.repository.ClickHouseRepository;
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

    public RuleEngineController(ClickHouseService clickHouseService) {
        this.clickHouseService = clickHouseService;
    }


    @PostMapping("/rule")
    public ResponseEntity saveRule(@RequestBody String rule) throws JsonProcessingException {
        clickHouseService.insertRule(rule);
        return ResponseEntity.ok(rule);
    }
}
