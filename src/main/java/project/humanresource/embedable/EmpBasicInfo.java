package project.humanresource.embedable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.time.LocalDate;
import java.time.LocalDate;

@Embeddable
@Getter
public class EmpBasicInfo {
    private String empNo;
    private String empNm;
    private String ctzNo;
    private LocalDate orgStaDate;
    private LocalDate orgEndDate;
    private LocalDate orgTransDate;
    private LocalDate hireDate;
    private LocalDate reitreDate;

    public EmpBasicInfo() {
    }

    @Builder
    public EmpBasicInfo(String empNo, String empNm, String ctzNo, LocalDate orgStaDate, LocalDate orgEndDate, LocalDate orgTransDate, LocalDate hireDate, LocalDate reitreDate, byte[] hireApplyFiles, String orgLeadYn, String password) {
        this.empNo = empNo;
        this.empNm = empNm;
        this.ctzNo = ctzNo;
        this.orgStaDate = orgStaDate;
        this.orgEndDate = orgEndDate;
        this.orgTransDate = orgTransDate;
        this.hireDate = hireDate;
        this.reitreDate = reitreDate;
        this.hireApplyFiles = hireApplyFiles;
        this.orgLeadYn = orgLeadYn;
        this.password = password;
    }

    @Lob
    @Column(columnDefinition="BLOB")
    private byte[] hireApplyFiles;

    private String orgLeadYn;
    private String password;

}
