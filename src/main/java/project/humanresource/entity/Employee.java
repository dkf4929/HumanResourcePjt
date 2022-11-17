package project.humanresource.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.humanresource.embedable.EmployeeBasicInfo;
import project.humanresource.entitybase.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/*
*1. 인사 담당자 사원 등록 후 조직장 승인 시
* 사번 채번 -> 부서 발령
*
* 2. 조직 발령 이후 인사담당자가 해당 사원의 상세 정보(가족관계, 취미 등) 입력
* */
@Entity
@Getter
@NoArgsConstructor
@SequenceGenerator(
        name = "EMP_GENERATOR",
        sequenceName = "EMPLOYEE_SEQUENCES",
        initialValue = 1, allocationSize = 50
)
public class Employee extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMP_GENERATOR")
    @Column(name = "emp_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "org_id")
    private Organization organization;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_detail_id")
    private EmployeeDetail empDetail;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<EmployeeFamily> employeeFamilies = new ArrayList<>();

    @Embedded
    private EmployeeBasicInfo empBasicInfo;

    @Builder
    public Employee(Organization organization, EmployeeDetail empDetail, EmployeeBasicInfo empBasicInfo, EmployeeFamily... employeeFamilies) {
        this.organization = organization;
        this.empDetail = empDetail;
        this.empBasicInfo = empBasicInfo;
        if (employeeFamilies != null) {
            System.out.println("Employee.Employee");
            for (EmployeeFamily employeeFamily : employeeFamilies) {
                System.out.println("employeeFamily = " + employeeFamily);
                this.employeeFamilies.add(employeeFamily);
                employeeFamily.setEmployee(this);
            }
        }
    }
}
