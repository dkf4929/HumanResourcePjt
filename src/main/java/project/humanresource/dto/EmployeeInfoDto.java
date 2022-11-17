package project.humanresource.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.humanresource.entity.Organization;

import java.time.LocalDate;

@Data
public class EmployeeInfoDto {

    private String empNo;
    private String empNm;
    private LocalDate hireDate;
    private String orgNm;
    private String gender;
    private String phoneNo;

    public EmployeeInfoDto() {
    }

    @QueryProjection
    public EmployeeInfoDto(String empNo, String empNm, LocalDate hireDate, String orgNm, String gender, String phoneNo) {
        this.empNo = empNo;
        this.empNm = empNm;
        this.hireDate = hireDate;
        this.orgNm = orgNm;
        this.gender = gender;
        this.phoneNo = phoneNo;
    }
}
