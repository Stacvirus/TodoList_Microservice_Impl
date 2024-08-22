package com.todo.user_service.service;

import com.todo.user_service.dto.UserDto;

public interface UserService {
    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto, String id);

    UserDto findOne(String id);

    void delete(String id);
}
