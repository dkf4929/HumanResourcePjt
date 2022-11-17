package project.humanresource.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import project.humanresource.interceptor.LoginInterceptor;
import project.humanresource.session.SessionManager;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final SessionManager sessionManager;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor(sessionManager))
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/logout");
    }
}
