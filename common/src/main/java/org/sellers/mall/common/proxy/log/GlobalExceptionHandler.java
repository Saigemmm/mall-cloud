package org.sellers.mall.common.proxy.log;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring MVC中的全局控制器增强类，这个类中可以包含 @ExceptionHandler、@InitBinder、@ModelAttribute 等注解的方法，
 * 这些方法会应用到所有被 @RequestMapping 注解的方法上，与AOP没有关系
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    //全局异常处理
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex) {
        // 这里可以记录日志、发送通知等
        // 然后返回一个错误响应给客户端
        Map<String, Object> body = new HashMap<>();
        body.put("message", "An unexpected error occurred");
        body.put("error", ex.getMessage());
        log.info("system exception handler caught an error info:\n{}", ExceptionUtils.getStackTrace(ex));
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //添加更多的 @ExceptionHandler 方法来处理不同类型的异常
}
