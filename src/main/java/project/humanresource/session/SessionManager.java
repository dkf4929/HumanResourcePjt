package project.humanresource.session;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.humanresource.exception.SessionExpireException;

import javax.servlet.http.*;
import java.util.Arrays;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SessionManager {
    public static final String COOKIE_NAME = "LOGIN_COOKIE";

    public void createSession(Object sessionValue, HttpServletRequest request, HttpServletResponse repsponse) {
        String uuid = UUID.randomUUID().toString();

        Cookie cookie = new Cookie(COOKIE_NAME, uuid);
        repsponse.addCookie(cookie);

        HttpSession session = request.getSession();
        session.setAttribute(uuid, sessionValue);
    }

    public Object findSessionValue(HttpServletRequest request) {
        Cookie cookie = findCookie(request);

        HttpSession session = request.getSession();
        return session.getAttribute(cookie.getValue());
    }

    private static Cookie findCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        return Arrays.stream(cookies)
                .filter((c) -> c.getName().equals(COOKIE_NAME))
                .findFirst()
                .orElseThrow(() -> {
                    throw new SessionExpireException("쿠키 또는 세션이 만료되었습니다. 다시 로그인 하세요");
                });
    }

    public void expire(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = findCookie(request);
        HttpSession session = request.getSession();

        cookie.setMaxAge(0);

        response.addCookie(cookie);
        session.invalidate();
    }
}
