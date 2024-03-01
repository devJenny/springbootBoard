package com.example.springbootBoard.config.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("jwt")
public class JwtProperties {
    // 해당 값들을 변수로 접근하는 데 사용
    private String issuer;
    private String secretKey;
}
