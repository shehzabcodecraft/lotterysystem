package com.shehzab.ruleengine.models;

import lombok.Data;

@Data
public class Condition {
    private String field;
    private String operator;
    private String value;
    private String maxValue;
}
