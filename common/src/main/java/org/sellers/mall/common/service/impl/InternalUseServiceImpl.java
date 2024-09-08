package org.sellers.mall.common.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sellers.mall.common.dto.UserDto;
import org.sellers.mall.common.service.InternalUserService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InternalUseServiceImpl implements InternalUserService {
    @Override
    public UserDto getUserByName(String username) {
        log.info("user service has wrong callback,please checkout");
        return null;
    }
}
