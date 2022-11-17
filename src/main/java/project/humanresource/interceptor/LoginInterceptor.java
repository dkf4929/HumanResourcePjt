package project.humanresource.interceptor;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import project.humanresource.dto.LoginDto;
import project.humanresource.session.SessionManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {
    private final SessionManager sessionManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoginDto session = (LoginDto) sessionManager.findSessionValue(request);

        log.info("login session = {}", session);

        return true;
    }
}
