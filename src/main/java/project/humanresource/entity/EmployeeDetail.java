package project.humanresource.entity;

import lombok.*;
import project.humanresource.entitybase.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee_detail")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetail extends BaseEntity {

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
}
