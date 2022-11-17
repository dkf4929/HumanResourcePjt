package project.humanresource.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.humanresource.dto.EmployeeDetailDto;
import project.humanresource.dto.EmployeeDto;
import project.humanresource.dto.EmployeeInfoDto;
import project.humanresource.embedable.EmployeeBasicInfo;
import project.humanresource.entity.Employee;
import project.humanresource.entity.EmployeeDetail;
import project.humanresource.exception.NoSuchEmployeeException;
import project.humanresource.repository.Employee.EmployeeDetailRepository;
import project.humanresource.repository.Employee.EmployeeRepository;
import project.humanresource.repository.Employee.EmployeeSearchParam;

import javax.persistence.EntityManager;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeDetailRepository detailRepository;
    private final EntityManager entityManager;

    public Long save(EmployeeDto dto) {
        String empNo = createEmpNo();

        Employee employee = new Employee().builder()
                .empBasicInfo(new EmployeeBasicInfo().builder()
                .empNm(dto.getEmpNm())
                .hireDate(dto.getHireDate())
                .empNo(empNo)
                .password(dto.getPassword()).build()).build();

        Employee savedEmployee = employeeRepository.save(employee);


        return savedEmployee.getId();
    }

    public Page<EmployeeInfoDto> findAllByParam(EmployeeSearchParam param, Pageable pageable) {
        return employeeRepository.findAllByParam(param, pageable);
    }

    public EmployeeInfoDto findById(Long empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(() -> {
            throw new NoSuchEmployeeException("존재하지 않는 사원입니다.");
        });

        return new EmployeeInfoDto(employee.getEmpBasicInfo().getEmpNo(),
                                   employee.getEmpBasicInfo().getEmpNm(),
                                   employee.getEmpBasicInfo().getHireDate(),
                                   employee.getOrganization().getOrgNm(),
                                   employee.getEmpDetail().getGender(),
                                   employee.getEmpDetail().getPhoneNo());
    }

    public void saveDetail(EmployeeDetailDto dto) {
        new EmployeeDetail().builder()
                .hobby(dto.getHobby())
                .extMail(dto.getExtMail())
                .intMail(dto.getIntMail())
                .homeAddress(dto.getHomeAddress())
                .phoneNo(dto.getPhoneNo())
                .build();
    }

    public List<EmployeeDetailDto> EmpDetInfo(Long empId) {
        return detailRepository.empDetInfo(empId);
    }

    private String createEmpNo() {
        /*
        * 사번 채번 규칙
        * 올해 년도 + 올해 입사자 count
        * */
        String yyyy = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy"));

        Long count = entityManager.createQuery("select count(e) from Employee e where substring(e.empBasicInfo.empNo, 0, 4) = :yyyy", Long.class)
                .setParameter("yyyy", yyyy)
                .getSingleResult();

        DecimalFormat df = new DecimalFormat("0000");

        String str = df.format(count + 1);

        return yyyy + str;
    }
}
