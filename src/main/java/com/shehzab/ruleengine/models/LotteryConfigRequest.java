package com.shehzab.ruleengine.models;

import lombok.Data;
import java.util.List;

@Data
public class LotteryConfigRequest {
    private String name;
    private String status;
    private DrawConfiguration drawConfiguration;
    private List<Rule> rules;
    private List<Rule> streakRules;
    private GlobalRules globalRules;
}




