package com.todo.user_service.service.implementation;

import com.todo.user_service.dto.UserDto;
import com.todo.user_service.exception.UserNotFoundException;
import com.todo.user_service.mapper.UserMapper;
import com.todo.user_service.model.User;
import com.todo.user_service.repository.UserRepository;
import com.todo.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDto create(UserDto userDto) {
        return mapper.toDto(repository.save(mapper.toModel(userDto)));
    }

    @Override
    public UserDto update(UserDto userDto, String id) {
        User gotUser = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user with id: "+id+" not found"));
        return mapper.toDto(repository.save(mapper.updateUser(userDto, gotUser)));
    }

    @Override
    public UserDto findOne(String id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new UserNotFoundException("user with id: "+id+" not found"));
    }

    @Override
    public void delete(String id) {
        if(id != null)
            repository.deleteById(id);
    }
}
