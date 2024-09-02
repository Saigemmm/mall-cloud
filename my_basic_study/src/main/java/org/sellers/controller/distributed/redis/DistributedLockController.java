package org.sellers.controller.distributed.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("DistributedLock")
public class DistributedLockController {

    private static final String LOCK_KEY = "product_101";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * redis分布式锁的简单演示；核心：setnx key value 命令
     */
    @GetMapping("/deductStocks")
    public String deductStocks() {
        //分布式锁的核心代码
        String clientId = UUID.randomUUID().toString();
        Boolean result = redisTemplate.opsForValue().setIfAbsent(LOCK_KEY, clientId, 10, TimeUnit.SECONDS);
//        redisTemplate.expire(LOCK_KEY,10, TimeUnit.SECONDS);//比delete更好的去除锁的方法，但是这行代码与上一行代码必须保持原子性
        try {
            if (!result) {
                return "error_code";
            }
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
            //????  redis释放分布式锁的原子性问题怎么解决？？？？  >>>>>>>锁续命，开创一个新的分线程，刷新锁的刷新时间
            if (clientId.equals(redisTemplate.opsForValue().get("lockKey")))
                redisTemplate.delete("lockKey");//若不加这段代码会死锁，可以通过这段思考什么是死锁
        }
        return "end";
    }

}
