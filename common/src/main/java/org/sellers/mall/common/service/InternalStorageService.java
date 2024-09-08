package org.sellers.mall.common.service;

import org.sellers.mall.common.service.impl.InternalStorageServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//服务降级需要sentinel来实现
@FeignClient(value = "mall-storage",fallback = InternalStorageServiceImpl.class)
@Component
public interface InternalStorageService {
    @PostMapping("/storage/getStorageByProductId")
    Integer getStorageByProductId(@RequestParam Integer productId);
}
