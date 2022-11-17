package project.humanresource.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.humanresource.entity.EmployeeFamily;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class EmployeeDetailDto {

    private LocalDate birthDate;
    private String gender;
    private String phoneNo;
    private String homeAddress;
    private String hobby;
    private String intMail;
    private String extMail;
    private List<EmployeeFamily> families;

    @QueryProjection
    @Builder
    public EmployeeDetailDto(LocalDate birthDate, String gender, String phoneNo, String homeAddress, String hobby, String intMail, String extMail, List<EmployeeFamily> families) {
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.homeAddress = homeAddress;
        this.hobby = hobby;
        this.intMail = intMail;
        this.extMail = extMail;
        this.families = families;
    }
}
