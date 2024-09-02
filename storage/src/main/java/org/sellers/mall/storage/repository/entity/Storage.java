package org.sellers.mall.storage.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("storage")
@Data
public class Storage {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer productId;
    private Integer total;
    private Integer balance;
}
