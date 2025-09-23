package com.shehzab.ruleengine.models;

import java.util.List;

public class PrizeConfiguration {
    private String type;
    private List<Tier> tiers;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Tier> getTiers() {
        return tiers;
    }

    public void setTiers(List<Tier> tiers) {
        this.tiers = tiers;
    }
}
