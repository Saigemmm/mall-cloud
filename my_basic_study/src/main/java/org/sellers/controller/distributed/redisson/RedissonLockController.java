package org.sellers.controller.distributed.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedissonLockController {
    private static final String LOCK_KEY = "product_101";

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private Redisson redisson;

    //redisson测试 已经封装好了的redis事务处理框架
    public String redissonReduceStocks() {
        RLock redissonLock = redisson.getLock(LOCK_KEY);
        try {
            redissonLock.lock();//加锁
            int stock = (int) redisTemplate.opsForValue().get("stock");
            if (stock > 0) {
                int realStock = stock - 1;
                redisTemplate.opsForValue().set("stock", realStock);
                System.out.println("扣减成功，剩余库存：" + realStock);
            } else {
                System.out.println("扣减失败，库存不足");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redissonLock.unlock();//解锁
        }
        return "end";
    }
}
