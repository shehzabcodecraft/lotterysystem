package com.shehzab.ruleengine.models;

import lombok.Data;

public class GlobalRules {
    private String maxTicketPerCustomer;
    private String cooldownPeriod;
    private String minEligibilityAge;
    private String maxEligibilityAge;

    public String getMaxTicketPerCustomer() {
        return maxTicketPerCustomer;
    }

    public void setMaxTicketPerCustomer(String maxTicketPerCustomer) {
        this.maxTicketPerCustomer = maxTicketPerCustomer;
    }

    public String getCooldownPeriod() {
        return cooldownPeriod;
    }

    public void setCooldownPeriod(String cooldownPeriod) {
        this.cooldownPeriod = cooldownPeriod;
    }

    public String getMinEligibilityAge() {
        return minEligibilityAge;
    }

    public void setMinEligibilityAge(String minEligibilityAge) {
        this.minEligibilityAge = minEligibilityAge;
    }

    public String getMaxEligibilityAge() {
        return maxEligibilityAge;
    }

    public void setMaxEligibilityAge(String maxEligibilityAge) {
        this.maxEligibilityAge = maxEligibilityAge;
    }
}
