package com.todo.user_service.controller;

import com.todo.user_service.dto.UserDto;
import com.todo.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto){
        return new ResponseEntity<>(service.create(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boolean> getOne(@PathVariable String id){
        boolean ans = false;
        UserDto user = service.findOne(id);
        if(user != null){
            ans = true;
        }
        return ResponseEntity.ok(ans);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto, @PathVariable String  id){
        return ResponseEntity.ok(service.update(userDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
