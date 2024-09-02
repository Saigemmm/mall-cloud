package org.sellers;

//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableAspectJAutoProxy//开启自动代理
@MapperScan(basePackages = "org.sellers.mapper")//开启mybatis需要扫描的Mapper包
@EnableCaching //开启基于注解的Redis模式
//@EnableRabbit //开启基于注解的RabbitMQ模式；@EnableRabbit+@RabbitListener监听消息队列的内容
@EnableTransactionManagement //开启事务管理
public class MyStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyStudyApplication.class, args);
    }
}
