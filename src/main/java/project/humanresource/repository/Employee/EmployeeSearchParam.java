package project.humanresource.repository.Employee;

import lombok.Data;

@Data
public class EmployeeSearchParam {

    private String empNo;
    private String empNm;
    private String orgCd;
    private String orgNm;
}
