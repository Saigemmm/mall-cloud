package org.sellers.mall.common.proxy.log;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

@Aspect
@Slf4j
@Component
public class LogAspect {
    //切点定义有很多方法，这里采用最常用的注解方式
    @Pointcut("@annotation(org.sellers.mall.common.proxy.log.AspectLog)")
    public void pointcut() {
    }

    //第一个*表示返回的参数可以是任何类型，
    //最后两个*表示任何包下的任何类，
    //(..)表示方法的参数列表可以是任意数量和类型的参数
    @Around("execution(* org.sellers.mall.order.service.impl.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 记录方法执行前的时间
        Instant start = Instant.now();
        // 执行目标方法
        Object proceed = joinPoint.proceed();
        // 记录方法执行后的时间，并计算执行时间
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        String methodName = joinPoint.getSignature().getName();
        //%s 占位符，被后面两个参数替代
        String logMessage = String.format("Method %s took %s ms to execute", methodName, duration.toMillis());
        log.info(logMessage);
        return proceed;
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
        //获取注解里的value值
        Method targetMethod = resolveMethod((ProceedingJoinPoint) joinPoint);
        AspectLog aspectLog = targetMethod.getAnnotation(AspectLog.class);
        String value = aspectLog.value();
        log.info("system internal error:{}", value);
        log.info("system internal error info {}", ExceptionUtils.getStackTrace(ex));
    }

    private Method resolveMethod(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Class<?> targetClass = point.getTarget().getClass();
        Method method = this.getDeclaredMethod(targetClass, signature.getName(), signature.getMethod().getParameterTypes());
        if (method == null) {
            throw new IllegalStateException("无法解析目标方法: " + signature.getMethod().getName());
        }
        return method;
    }

    /**
     * Class类下的getDeclaredMethod本来是不能获取父类继承的方法的，但本方法可以
     * 根据方法名获取类本身声明的所有方法，无论它们的访问级别如何
     *
     * @param clazz          方法所属的类
     * @param name           方法名
     * @param parameterTypes 该方法入参类型
     * @return 该方法
     */
    private Method getDeclaredMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null) {
                return getDeclaredMethod(superClass, name, parameterTypes);
            }
        }
        return null;
    }
}
