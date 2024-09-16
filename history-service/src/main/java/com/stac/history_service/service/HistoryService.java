package com.stac.history_service.service;

import com.stac.history_service.dto.HistoryDto;
import com.stac.history_service.entity.History;

import java.util.List;

public interface HistoryService {
    History create(HistoryDto historyDto);

    History findById(Long id);

    List<History> findWithUserId(String userId);
}
