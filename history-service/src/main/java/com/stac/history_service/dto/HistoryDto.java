package com.stac.history_service.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class HistoryDto {
    private Long taskId;
    private String userId;
    private String title;

    private ZonedDateTime createdAt;
}
