package project.humanresource.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.humanresource.entitybase.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee_detail")
@Getter
public class EmpDetail extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "emp_det_id")
    private Long id;

    private LocalDate birthDate;
    private String gender;
    private String phoneNo;
    private String homeAddress;
    private String hobby;
    private String intMail;
    private String extMail;

//    @Lob
//    @Column(columnDefinition="BLOB")
//    private byte empImg;

    public EmpDetail() {
    }

    @Builder
    public EmpDetail(LocalDate birthDate, String gender, String phoneNo, String homeAddress, String hobby, String intMail, String extMail) {
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.homeAddress = homeAddress;
        this.hobby = hobby;
        this.intMail = intMail;
        this.extMail = extMail;
    }
}
