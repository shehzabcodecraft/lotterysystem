package com.shehzab.ruleengine.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shehzab.ruleengine.models.DrawConfiguration;
import com.shehzab.ruleengine.models.GlobalRules;
import com.shehzab.ruleengine.models.Rule;
import com.shehzab.ruleengine.models.Tier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class ClickHouseRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;

    public ClickHouseRepository(JdbcTemplate jdbcTemplate,ObjectMapper objectMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.objectMapper = objectMapper;
    }

    public List<Map<String, Object>> findEligibleCustomers(String sql) {
        return jdbcTemplate.queryForList(sql);
    }

    public boolean ping() {
        Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        return result != null && result == 1;
    }

    public void insertLottery(UUID lotteryId, String name, String status) {
        jdbcTemplate.update(
                "INSERT INTO lottery (id, name, status) VALUES (?, ?, ?)",
                lotteryId, name, status
        );
    }

    public UUID insertDrawConfiguration(UUID lotteryId, DrawConfiguration drawConfig) {
        UUID drawConfigId = UUID.randomUUID();
        jdbcTemplate.update(
                "INSERT INTO draw_configuration (id, lottery_id, drawType, prizeType) VALUES (?, ?, ?, ?)",
                drawConfigId, lotteryId,
                drawConfig.getDrawType(),
                drawConfig.getPrizeConfiguration().getType()
        );
        return drawConfigId;
    }

    public void insertPrizeTiers(UUID drawConfigId, List<Tier> tiers) {
        for (Tier tier : tiers) {
            jdbcTemplate.update(
                    "INSERT INTO prize_tier (id, draw_config_id, rank, amount, numberOfWinners) VALUES (?, ?, ?, ?, ?)",
                    UUID.randomUUID(), drawConfigId,
                    Integer.parseInt(tier.getRank()),
                    Double.parseDouble(tier.getAmount()),
                    Integer.parseInt(tier.getNumberOfWinners())
            );
        }
    }

    public void insertRules(UUID lotteryId, List<Rule> rules, String ruleType) throws Exception {
        if (rules == null) return;
        for (Rule rule : rules) {
            String json = objectMapper.writeValueAsString(rule);
            jdbcTemplate.update(
                    "INSERT INTO rules (id, lottery_id, ruleName, priority, enabled, ruleType, ruleJson) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    UUID.randomUUID(),
                    lotteryId,
                    rule.getRuleName(),
                    rule.getPriority(),
                    rule.isEnabled() ? 1 : 0,
                    ruleType,
                    json
            );
        }
    }

    public void insertGlobalRules(UUID lotteryId, GlobalRules gr) {
        jdbcTemplate.update(
                "INSERT INTO global_rules (id, lottery_id, maxTicketPerCustomer, cooldownPeriod, minEligibilityAge, maxEligibilityAge) VALUES (?, ?, ?, ?, ?, ?)",
                UUID.randomUUID(),
                lotteryId,
                Integer.parseInt(gr.getMaxTicketPerCustomer()),
                gr.getCooldownPeriod(),
                Integer.parseInt(gr.getMinEligibilityAge()),
                Integer.parseInt(gr.getMaxEligibilityAge())
        );
    }
}
