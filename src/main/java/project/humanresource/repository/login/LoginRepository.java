package project.humanresource.repository.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.humanresource.dto.LoginDto;
import project.humanresource.dto.LoginParamDto;
import project.humanresource.entity.Employee;

import java.util.Optional;

public interface LoginRepository {

    public LoginDto findByLoginId(LoginParamDto param);
}
