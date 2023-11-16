package com.DevEx.DevExBE.global.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);

        //활성화 테스트 test
        CorsFilter corsFilter = new CorsFilter(source);
        System.out.println("CorsFilter is active!");
        return corsFilter;
    }
}