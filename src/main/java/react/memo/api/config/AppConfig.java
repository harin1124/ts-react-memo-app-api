package react.memo.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Autowired
	private CustomInterceptor customIntegerceptor;

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(customIntegerceptor)
			.addPathPatterns("/**");
			//.excludePathPatterns("/user/login");
	}
}
