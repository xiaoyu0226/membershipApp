package com.example.demo.service.impl;

import com.example.demo.dto.FamilyDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exceptions.FamilyNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.Family;
import com.example.demo.model.User;
import com.example.demo.repository.FamilyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FamilyService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User could not be found"));
        return mapToDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setAppUserRole(userDto.getAppUserRole());
//        user.setClient(userDto.getClient());
//        user.setPartner(userDto.getPartner());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return mapToDto(user);
    }

    @Override
    public UserDto updateUserId(UserDto userDto, int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User could not be updated"));

        user.setAppUserRole(userDto.getAppUserRole());
//        user.setClient(userDto.getClient());
//        user.setPartner(userDto.getPartner());
        user.setPassword(userDto.getPassword());

        User updatedUser = userRepository.save(user);
        return mapToDto(updatedUser);
    }

    private UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setAppUserRole(user.getAppUserRole());
//        userDto.setClient(user.getClient());
//        userDto.setPartner(user.getPartner());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    private User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setAppUserRole(userDto.getAppUserRole());
//        user.setClient(userDto.getClient());
//        user.setPartner(userDto.getPartner());
        user.setPassword(userDto.getPassword());
        return user;
    }

}
