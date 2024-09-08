package org.sellers.mall.common.service;

import org.sellers.mall.common.dto.UserDto;
import org.sellers.mall.common.service.impl.InternalUseServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "mall-user", fallback = InternalUseServiceImpl.class)
@Component
public interface InternalUserService {
    @RequestMapping("/user/getUserByName")
    UserDto getUserByName(@RequestParam String username);
}
