package project.humanresource.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.humanresource.embedable.EmpBasicInfo;
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
@NoArgsConstructor(access = AccessLevel.PUBLIC)
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
    private EmpDetail empDetail;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<EmpFamily> employeeFamilies = new ArrayList<>();

    @Embedded
    private EmpBasicInfo empBasicInfo;

    @Builder
    public Employee(Organization organization, EmpDetail empDetail, EmpBasicInfo empBasicInfo, EmpFamily... employeeFamilies) {
        this.organization = organization;
        this.empDetail = empDetail;
        this.empBasicInfo = empBasicInfo;
        if (employeeFamilies != null) {
            System.out.println("Employee.Employee");
            for (EmpFamily employeeFamily : employeeFamilies) {
                System.out.println("employeeFamily = " + employeeFamily);
                this.employeeFamilies.add(employeeFamily);
                employeeFamily.setEmployee(this);
            }
        }
    }
}
