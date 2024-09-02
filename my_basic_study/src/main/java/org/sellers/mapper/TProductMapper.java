package org.sellers.mapper;

import org.sellers.domain.TProduct;
import org.springframework.stereotype.Repository;
import tk.mybatis.MyMapper;

@Repository
public interface TProductMapper extends MyMapper<TProduct> {
}