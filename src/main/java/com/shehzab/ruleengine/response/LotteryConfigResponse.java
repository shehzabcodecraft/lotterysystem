package com.shehzab.ruleengine.response;

import java.util.UUID;

public record LotteryConfigResponse(UUID lotteryId, String name, String status) {
}
