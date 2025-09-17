package com.shehzab.ruleengine.controller;

import com.shehzab.ruleengine.service.ClickHouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClickHouseController {
    private final ClickHouseService service;

    public ClickHouseController(ClickHouseService service) {
        this.service = service;
    }

    @GetMapping("/ping")
    public String ping() {
        try {
            return service.ping()
                    ? "ClickHouse Connected"
                    : "ClickHouse Failed";
        } catch (Exception e) {
            return "ClickHouse Error: " + e.getMessage();
        }
    }
}
