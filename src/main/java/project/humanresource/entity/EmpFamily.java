package project.humanresource.entity;

import lombok.*;
import project.humanresource.embedable.FamilyInfo;
import project.humanresource.entitybase.BaseEntity;

import javax.persistence.*;

@Getter
@Entity
@ToString
public class EmpFamily extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "emp_fam_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @Embedded
    private FamilyInfo familyInfo;

    @Builder
    public EmpFamily(FamilyInfo familyInfo) {
        this.familyInfo = familyInfo;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmpFamily() {
    }
}
