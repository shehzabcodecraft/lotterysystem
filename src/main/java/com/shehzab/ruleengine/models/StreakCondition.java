package com.shehzab.ruleengine.models;

import lombok.Data;

@Data
public class StreakCondition {
    private String metric;
    private String threshold;
    private String streakLength;
    private String streakLengthUnit;
    private Reward reward;
    private String rewardValue;
    private BrokenStreakPolicy brokenStreakPolicy;
}
