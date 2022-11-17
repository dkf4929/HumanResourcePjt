package project.humanresource.embedable;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.time.LocalDate;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
public class EmployeeBasicInfo {
    @Column(length = 8)
    private String empNo;

    @Column(length = 30)
    private String empNm;

    private String ctzNo;
    private LocalDate orgStaDate;
    private LocalDate orgEndDate;
    private LocalDate orgTransDate;
    private LocalDate hireDate;
    private LocalDate reitreDate;

    @Lob
    @Column(columnDefinition="BLOB")
    private byte[] hireApplyFiles;

    @ColumnDefault("'N'")
    private String orgLeadYn;
    private String password;

}
