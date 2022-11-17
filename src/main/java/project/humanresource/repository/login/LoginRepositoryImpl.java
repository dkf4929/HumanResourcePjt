package project.humanresource.repository.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.humanresource.dto.LoginDto;
import project.humanresource.dto.LoginParamDto;
import project.humanresource.entity.Employee;
import project.humanresource.exception.LoginFailException;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class LoginRepositoryImpl implements LoginRepository {
    private final EntityManager entityManager;

    private static RuntimeException get() {
        throw new LoginFailException("아이디 또는 비밀번호가 일치하지 않습니다.");
    }

    @Override
    public LoginDto findByLoginId(LoginParamDto param) {
        List<Employee> result = entityManager.createQuery("select e from Employee e where e.empBasicInfo.empNo = :loginId and e.empBasicInfo.password = :password", Employee.class)
                .setParameter("loginId", param.getLoginId())
                .setParameter("password", param.getPassword())
                .getResultList();

        Employee employee = result.stream().findFirst().orElseGet(() -> {
            throw new LoginFailException("아이디 또는 비밀번호가 일치하지 않습니다.");
        });



        return new LoginDto(employee.getEmpBasicInfo().getEmpNo(), employee.getEmpBasicInfo().getEmpNm(), employee.getId());
    }
}
