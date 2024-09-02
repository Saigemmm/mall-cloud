package org.sellers.mall.common.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sellers.mall.common.service.InternalStorageService;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InternalStorageServiceImpl implements InternalStorageService {
    @Override
    public Integer getStorageByProductId(Integer productId) {
        log.info("storage service has wrong callback,please checkout");
        return null;
    }
}
