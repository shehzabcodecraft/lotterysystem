package com.shehzab.ruleengine.models;

import lombok.Data;

import java.util.List;

@Data
public class Rule {
    private String ruleName;
    private String description;
    private String priority;
    private boolean enabled;
    private List<Condition> conditions;
    private TicketAllocation ticketAllocation;
    private List<String> actions;
    private StreakCondition streakCondition;
}