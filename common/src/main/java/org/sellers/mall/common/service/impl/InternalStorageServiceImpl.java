package org.sellers.mall.common.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.sellers.mall.common.service.InternalStorageService;
import org.springframework.stereotype.Component;

/**
 * 这个熔断器回调类不生效，因为没有引入hystrix依赖或者Resilience4j依赖，两者都是用来做熔断器的
 * 举例：如果要使用hystrix需要引入依赖，且在application.yml配置文件中开启feign对hystrix的支持：feign.hystrix.enabled:ture
 *      然后在创建一个实现了Feign客户端接口的熔断器类，需要实现MyServiceClient接口，用于定义服务调用失败时的回退逻辑
 */
@Component
@Slf4j
public class InternalStorageServiceImpl implements InternalStorageService {
    @Override
    public Integer getStorageByProductId(Integer productId) {
        log.info("storage service has wrong callback,please checkout");
        return null;
    }
}
