package com.shehzab.ruleengine.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ClickHouseRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClickHouseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findEligibleCustomers(String sql) {
        return jdbcTemplate.queryForList(sql);
    }

    public boolean ping() {
        Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        return result != null && result == 1;
    }

    public int insertRule(String ruleName, String field) {
        String sql = "INSERT INTO customers (ruleName, field, created_at) VALUES (?, ?, now())";
        return jdbcTemplate.update(sql, ruleName, field);
    }
}
