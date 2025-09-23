package com.shehzab.ruleengine.models;

import lombok.Data;

import java.util.List;

@Data
public class PrizeConfiguration {
    private String type;
    private List<Tier> tiers;
}
