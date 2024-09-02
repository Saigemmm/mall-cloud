package tk.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 自己的mapper，该接口不能被扫描到，否则会报错
 * springboot默认扫描包路径是application在哪个包下就默认扫描哪个包
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
