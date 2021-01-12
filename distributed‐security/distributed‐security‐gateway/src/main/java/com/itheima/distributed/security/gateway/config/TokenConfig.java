package com.itheima.distributed.security.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Program Name: distributed‐security
 * Created by yanlp on 2021-01-10
 *
 * @author yanlp
 * @version 1.0
 */
@Configuration
public class TokenConfig {

    private String SIGNING_KEY= "uaa123";

    @Bean
    public TokenStore tokenStore() {
        // return new InMemoryTokenStore();
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        // 对称秘钥,资源服务器使用该秘钥来解密
        tokenConverter.setSigningKey(SIGNING_KEY);
        return tokenConverter;
    }
}
