package org.sellers.mall.user.service;

import lombok.extern.slf4j.Slf4j;
import org.sellers.mall.common.dto.UserDto;
import org.sellers.mall.user.repository.UserRepository;
import org.sellers.mall.user.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDto getUserByName(String username) {
        User user = userRepository.findByUsername(username);
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUserName())
                .password(user.getPassword())
                .build();
    }
}
