package project.humanresource.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import project.humanresource.embedable.EmployeeBasicInfo;
import project.humanresource.embedable.FamilyInfo;
import project.humanresource.entity.EmployeeDetail;
import project.humanresource.entity.EmployeeFamily;
import project.humanresource.entity.Employee;
import project.humanresource.entity.Organization;
import project.humanresource.repository.Employee.EmployeeRepository;

import java.time.LocalDate;

@SpringBootTest
@Transactional
class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    @Commit
    void before() {
        EmployeeBasicInfo info = new EmployeeBasicInfo().builder()
                .empNm("memberA")
                .ctzNo("111111-1111111")
                .orgStaDate(LocalDate.now())
                .password("1234")
                .build();

        Organization supCompany = new Organization().builder()
                .orgCreateDate(LocalDate.now())
                .orgNm("HR COMPANY")
                .orgCd("000001")
                .build();

        Organization org = new Organization().builder()
                .orgCd("000002")
                .orgNm("인사부")
                .superOrgId(supCompany.getId())
                .orgCreateDate(LocalDate.now())
                .build();

        EmployeeDetail detail = new EmployeeDetail().builder()
                .birthDate(LocalDate.of(1970, 01, 01))
                .gender("M")
                .phoneNo("010-1111-2222")
                .homeAddress("도봉로 642-30")
                .hobby("독서")
                .intMail("abc@hrCompany.com")
                .extMail("abc@naver.com")
                .build();

        FamilyInfo child = new FamilyInfo().builder()
                .famStaDate(LocalDate.of(2000, 01, 01))
                .famName("childA")
                .famRel("CHILD")
                .famBirthDate(LocalDate.of(2000, 01, 01))
                .build();

        EmployeeFamily family = new EmployeeFamily().builder()
                .familyInfo(child)
                .build();

        Employee employee = new Employee().builder()
                .empBasicInfo(info)
                .empDetail(detail)
                .employeeFamilies(new EmployeeFamily[]{family})
                .organization(org)
                .build();

        employeeRepository.save(employee);
    }

    @Test
    @Commit
    void CRUD() {
    }
}