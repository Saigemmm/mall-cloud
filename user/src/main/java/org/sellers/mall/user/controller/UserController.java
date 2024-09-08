package org.sellers.mall.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.sellers.mall.common.dto.UserDto;
import org.sellers.mall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUserByName")
    public UserDto getUserByName(@RequestParam String username) {
        return userService.getUserByName(username;
    }
}
