package org.sellers.mapper;

import org.sellers.domain.TUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

@Repository
public interface TUserMapper extends MyMapper<TUser> {
}