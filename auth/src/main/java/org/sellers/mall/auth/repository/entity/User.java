package org.sellers.mall.auth.repository.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
}
