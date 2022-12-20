package com.nhnacademy.jdbc.board.domains.user.mapper;

import com.nhnacademy.jdbc.board.domains.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;


@Mapper
public interface UserMapper {
    Optional<User> selectUser(@Param("userId") String userId);

    List<User> selectUsers();
}
