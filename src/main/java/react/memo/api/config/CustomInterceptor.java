package react.memo.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class CustomInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("====================================");
		System.out.println("CustomInterceptor");
		System.out.printf("METHOD [%s]\r\n", request.getMethod());
		System.out.printf("URI [%s]\r\n", request.getRequestURI());
		System.out.println("====================================");
		return true;
	}
}