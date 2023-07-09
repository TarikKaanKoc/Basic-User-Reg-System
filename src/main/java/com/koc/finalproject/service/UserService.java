package com.koc.finalproject.service;

import com.koc.finalproject.dto.UserDto;
import com.koc.finalproject.entity.User;
import com.koc.finalproject.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final IUserRepository userRepository;

    public UserDto getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(this::entityToDto).orElse(null);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return entityListToDtoList(users);
    }

    public boolean createUser(UserDto dto) {
        boolean doesUserExist = userRepository.existsByEmail(dto.getEmail());
        if (doesUserExist) {
            return false;
        } else {
            User user = dtoToEntity(dto);
            userRepository.save(user);
            return true;
        }
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public boolean updateUser(UserDto dto) {
        Optional<User> optionalUser = userRepository.findById(dto.getId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            BeanUtils.copyProperties(dto, user, "id"); // ignore id field - Id güncellenmesin
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    private UserDto entityToDto(User user) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    private List<UserDto> entityListToDtoList(List<User> users) {
        return users.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    private User dtoToEntity(UserDto dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return entityToDto(user);
    }

    public boolean doesUserExistByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public UserDto getUserByPhone(String phone) {
        User user = userRepository.findByPhone(phone);
        return entityToDto(user);
    }

    public boolean doesUserExistByPhone(String phone) {
        return userRepository.existsByPhone(phone);
    }
}
