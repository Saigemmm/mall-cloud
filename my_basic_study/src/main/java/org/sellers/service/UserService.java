package org.sellers.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sellers.mapper.TUserMapper;
import org.sellers.domain.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private TUserMapper userMapper;

    @Autowired
    @Qualifier("userRedisTemplate")
    private RedisTemplate redisTemplate;

    public List<TUser> selectAllUser() {
        List<TUser> list = userMapper.selectAll();
        redisTemplate.opsForSet().add("userSet", list);
        return list;
    }

    /**
     * Mybatis分页
     */
    public PageInfo<TUser> pagingSelectAllName(int pageNum, int pageSize) {
        Example example = new Example(TUser.class);
        PageHelper.startPage(pageNum, pageSize);
        List<TUser> list = userMapper.selectByExample(example);
        PageInfo<TUser> pageInfo = new PageInfo<>(list);
        redisTemplate.opsForList().leftPushAll("pagingUserList", pageInfo);
        return pageInfo;
    }
}
