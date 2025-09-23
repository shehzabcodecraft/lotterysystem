package com.shehzab.ruleengine.models;

public class DrawConfiguration {
    private String drawType;
    private PrizeConfiguration prizeConfiguration;

    public String getDrawType() {
        return drawType;
    }

    public void setDrawType(String drawType) {
        this.drawType = drawType;
    }

    public PrizeConfiguration getPrizeConfiguration() {
        return prizeConfiguration;
    }

    public void setPrizeConfiguration(PrizeConfiguration prizeConfiguration) {
        this.prizeConfiguration = prizeConfiguration;
    }
}
