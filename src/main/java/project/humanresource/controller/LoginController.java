package project.humanresource.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.humanresource.dto.LoginDto;
import project.humanresource.dto.LoginParamDto;
import project.humanresource.service.LoginService;
import project.humanresource.session.SessionManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final SessionManager sessionManager;

    @PostMapping("/login")
    @ResponseBody
    public LoginDto findByLoginId(@RequestBody @Validated LoginParamDto param, HttpServletRequest request, HttpServletResponse response) {
        LoginDto loginEmp = loginService.findByLoginId(param);
        sessionManager.createSession(loginEmp, request, response);

        return loginEmp;
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        sessionManager.expire(request, response);
    }
}
