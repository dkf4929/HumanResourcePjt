package project.humanresource.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import project.humanresource.dto.EmployeeDto;
import project.humanresource.embedable.EmpBasicInfo;
import project.humanresource.entity.Employee;
import project.humanresource.repository.EmployeeRepository;

import javax.persistence.EntityManager;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EntityManager entityManager;

    public Long save(EmployeeDto dto) {
        String empNo = createEmpNo();

        Employee employee = new Employee().builder()
                .empBasicInfo(new EmpBasicInfo().builder()
                .empNm(dto.getEmpNm())
                .hireDate(dto.getHireDate())
                .empNo(empNo)
                .password(dto.getPassword()).build()).build();

        Employee savedEmployee = employeeRepository.save(employee);


        return savedEmployee.getId();
    }

    private String createEmpNo() {
        /*
        * 사번 채번 규칙
        * 올해 년도 + 올해 입사자 count
        * */
        String yyyy = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy"));

        Long count = entityManager.createQuery("select count(e) + 1 from Employee e where substring(e.empBasicInfo.empNo, 0, 4) = :yyyy", Long.class)
                .setParameter("yyyy", yyyy)
                .getSingleResult();

        DecimalFormat df = new DecimalFormat("0000");

        String str = df.format(count);

        return yyyy + str;
    }
}
