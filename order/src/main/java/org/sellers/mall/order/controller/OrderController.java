package org.sellers.mall.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.sellers.mall.common.service.InternalStorageService;
import org.sellers.mall.order.config.PatternProperties;
import org.sellers.mall.order.repository.entity.Order;
import org.sellers.mall.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
@Slf4j
@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
//方式1，在@value变量所在的类上加上@RefreshScope注解即可实现，方式2参见配置类PatternProperties
//RefreshScope这个注解有个坑，在不修改默认proxyMode时，@Value注入会是null
public class OrderController {
    @Autowired
    private InternalStorageService internalStorageService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PatternProperties patternProperties;

    @Value("${dynamic.test}")
    private String dynamicTest;

    @GetMapping("/dynamicTest")
    private String dynamicTest() {
        log.info("nacos dynamic refresh configuration, such as {}", dynamicTest);
        SimpleDateFormat sf = new SimpleDateFormat(patternProperties.getDateFormat());
        return sf.format(new Date());
    }

    @GetMapping("/getOrderList")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/getProductBalance")
    public Integer getProductBalance(Integer productId) {
        return internalStorageService.getStorageByProductId(productId);
    }
}
