package com.stac.history_service.service;

import com.stac.history_service.dto.HistoryDto;
import com.stac.history_service.entity.History;
import com.stac.history_service.errors.exceptions.HistoryNotFoundException;
import com.stac.history_service.mapper.HistoryMapper;
import com.stac.history_service.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository repository;
    private final HistoryMapper mapper;


    @Override
    public History create(HistoryDto historyDto) {
        return repository.save(mapper.toEntity(historyDto));
    }

    @Override
    public History findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new HistoryNotFoundException("history not found!")
        );
    }

    @Override
    public List<History> findWithUserId(String userId) {
        return repository.findAllByUserId(userId);
    }
}
