package project.humanresource.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.humanresource.dto.LoginDto;
import project.humanresource.dto.LoginParamDto;
import project.humanresource.entity.Employee;
import project.humanresource.repository.login.LoginRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginDto findByLoginId(LoginParamDto param) {
        return loginRepository.findByLoginId(param);
    }
}
