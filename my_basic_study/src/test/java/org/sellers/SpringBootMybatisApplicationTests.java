package org.sellers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.sellers.domain.TExample;
import org.sellers.domain.TUser;
import org.sellers.mapper.TUserMapper;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@SpringBootTest(classes = MyStudyApplication.class)
@Transactional
@Rollback
class SpringBootMybatisApplicationTests {

    @Autowired
    private TUserMapper tUserMapper;

    /**
     * 分页查询
     */
    @Test
    public void testPageSelect(){
        PageHelper.startPage(1,2);
        Example example=new Example(TUser.class);
        PageInfo<TUser> pageInfo= new PageInfo<>(tUserMapper.selectByExample(example));
        List<TUser> list=pageInfo.getList();
        for(TUser account:list){
            System.out.println(account.getUserName());
        }
    }

    /**
     * redis测试
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;//操作字符串

    @Autowired
    private RedisTemplate redisTemplate;//操作对象

    /**
     * rabbitMQ测试
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    @RabbitListener(queues = "2222news")
    public void testRabbit(TExample example){
        System.out.println(example.getExampleName());
    }

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void createExchange(){
        //amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange")); //创建exchange
        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("1111news",Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqp.hah",null));
    }

}
