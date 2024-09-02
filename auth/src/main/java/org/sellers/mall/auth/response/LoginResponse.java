package org.sellers.mall.auth.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;

    private String refreshToken;

    private String userId;

    private String username;
}
