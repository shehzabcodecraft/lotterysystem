package com.shehzab.ruleengine.models;

import lombok.Data;

@Data
public class GlobalRules {
    private String maxTicketPerCustomer;
    private String cooldownPeriod;
    private String minEligibilityAge;
    private String maxEligibilityAge;
}
