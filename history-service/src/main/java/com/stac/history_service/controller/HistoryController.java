package com.stac.history_service.controller;

import com.stac.history_service.dto.HistoryDto;
import com.stac.history_service.entity.History;
import com.stac.history_service.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/history")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService service;

    @PostMapping
    public ResponseEntity<History> saveHistory(@RequestBody HistoryDto historyDto) {
        return new ResponseEntity<>(service.create(historyDto), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<History>> getUserHistory(@PathVariable String userId) {
        return ResponseEntity.ok(service.findWithUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<History> getHistory(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
