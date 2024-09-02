package org.sellers.basic.DesignPattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 以字体提供器接口为例创建动态代理实现类
 * 如果想获取图片、音乐等其他资源，那么一个FontProvider接口就不够用了，还得提供ImageProvider和MusicProvider接口
 * 但是他们的核心方法都是get*()，功能会重复，此时就用到了动态代理
 */
public class CachedProviderHandler implements InvocationHandler {
    private final Map<String, Object> cached = new HashMap<>();

    private final Object target;

    public CachedProviderHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Type[] types = method.getParameterTypes();//获取要执行的方法名、参数等信息
        //根据函数的开头名、参数个数、参数类型判断是否是获取资源（get*()方法）的方法
        if (method.getName().matches("get.+")
                && types.length == 1
                && (types[0] == String.class)) {
            String key = (String) args[0];//本文的例子中，接口方法只有一个参数，获取的就是这个传入的参数
            //先读缓存
            Object value = cached.get(key);
            if (value == null) {
                value = method.invoke(target, args);
                cached.put(key, value);
            }
            return value;
        }
        return method.invoke(target, args);
    }
}
