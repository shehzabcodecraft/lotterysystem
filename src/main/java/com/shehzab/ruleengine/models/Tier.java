package com.shehzab.ruleengine.models;

import lombok.Data;

public class Tier {
    private String rank;
    private String amount;
    private String numberOfWinners;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNumberOfWinners() {
        return numberOfWinners;
    }

    public void setNumberOfWinners(String numberOfWinners) {
        this.numberOfWinners = numberOfWinners;
    }
}
