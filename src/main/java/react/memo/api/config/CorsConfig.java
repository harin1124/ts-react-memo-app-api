package react.memo.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*"); // 모든 IP 응답 허용
        config.addAllowedHeader("*"); // 모든 Header 에 응답 허용
        config.addAllowedMethod("*"); // 모든 Method 에 요청 허용
        
        source.registerCorsConfiguration("/**", config);
        
        return new CorsFilter(source);
    }
}