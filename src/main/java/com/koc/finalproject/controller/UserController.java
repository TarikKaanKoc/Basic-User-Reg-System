package com.koc.finalproject.controller;

import com.koc.finalproject.dto.UserDto;
import com.koc.finalproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @PostMapping("/create-user")
    @ResponseBody
    public boolean createUser(@RequestBody UserDto dto) {
        return userService.createUser(dto);
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String, Boolean>> updateUser(@RequestBody UserDto dto) {
        boolean updateResponse = userService.updateUser(dto);
        Map<String, Boolean> response = new HashMap<>();
        response.put("status", updateResponse);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/delete")
    @ResponseBody
    public void deleteUser(@RequestParam Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("/get-all")
    @ResponseBody
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get-userId")
    @ResponseBody
    public UserDto getUserById(@RequestParam Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/get-userByEmail")
    @ResponseBody
    public UserDto getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/does-userExistByEmail")
    @ResponseBody
    public boolean doesUserExistByEmail(@RequestParam String email) {
        return userService.doesUserExistByEmail(email);
    }

    @GetMapping("/get-userByPhone")
    @ResponseBody
    public UserDto getUserByPhone(@RequestParam String phone) {
        return userService.getUserByPhone(phone);
    }

    @GetMapping("/does-userExistByPhone")
    @ResponseBody
    public boolean doesUserExistByPhone(@RequestParam String phone) {
        return userService.doesUserExistByPhone(phone);
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/getall")
    public String getAllForm() {
        return "getall";
    }
}
