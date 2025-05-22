package com.fiap.dasa_api.infra.mappers.user;

import com.fiap.dasa_api.domain.dto.user.ResponseUserDTO;
import com.fiap.dasa_api.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ResponseUserDTO toUserResponse(User entity);
}
