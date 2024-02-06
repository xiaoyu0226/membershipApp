package com.example.demo.service;

import com.example.demo.dto.FamilyDto;
import com.example.demo.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(int id);

    UserDto createUser(UserDto userDto);

    UserDto updateUserId(UserDto userDto, int userId);
}
