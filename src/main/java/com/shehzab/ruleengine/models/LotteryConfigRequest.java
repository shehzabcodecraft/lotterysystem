package com.shehzab.ruleengine.models;

import java.util.List;

public class LotteryConfigRequest {
    private String name;
    private String status;
    private DrawConfiguration drawConfiguration;
    private List<Rule> rules;
    private List<Rule> streakRules;
    private GlobalRules globalRules;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DrawConfiguration getDrawConfiguration() {
        return drawConfiguration;
    }

    public void setDrawConfiguration(DrawConfiguration drawConfiguration) {
        this.drawConfiguration = drawConfiguration;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public List<Rule> getStreakRules() {
        return streakRules;
    }

    public void setStreakRules(List<Rule> streakRules) {
        this.streakRules = streakRules;
    }

    public GlobalRules getGlobalRules() {
        return globalRules;
    }

    public void setGlobalRules(GlobalRules globalRules) {
        this.globalRules = globalRules;
    }
}




