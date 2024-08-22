package com.todo.user_service.mapper;

import com.todo.user_service.dto.UserDto;
import com.todo.user_service.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toModel(UserDto userDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUser(UserDto userDto, @MappingTarget User user);
}
