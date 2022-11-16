package project.humanresource.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
public class EmployeeDto {

    @NotEmpty
    @Column(length = 30)
    private String empNm;
    private LocalDate hireDate;

    @NotEmpty
    @Length(max = 30)
    private String password;

    private String empNo;
}
