package com.shehzab.ruleengine.models;

import lombok.Data;

import java.util.List;

public class Rule {
    private String ruleName;
    private String description;
    private String priority;
    private boolean enabled;
    private List<Condition> conditions;
    private TicketAllocation ticketAllocation;
    private List<String> actions;
    private StreakCondition streakCondition;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public TicketAllocation getTicketAllocation() {
        return ticketAllocation;
    }

    public void setTicketAllocation(TicketAllocation ticketAllocation) {
        this.ticketAllocation = ticketAllocation;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public StreakCondition getStreakCondition() {
        return streakCondition;
    }

    public void setStreakCondition(StreakCondition streakCondition) {
        this.streakCondition = streakCondition;
    }
}