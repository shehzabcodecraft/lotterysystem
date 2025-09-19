package com.shehzab.ruleengine.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RuleEngineController {

    public RuleEngineController() {
    }

    @PostMapping("/rule")
    public ResponseEntity saveRule(@RequestBody String rule) {
        return ResponseEntity.ok(rule);
    }
}
