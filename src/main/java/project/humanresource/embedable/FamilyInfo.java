package project.humanresource.embedable;

import lombok.*;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@ToString
public class FamilyInfo {
    private String famName;
    private LocalDate famBirthDate;
    private String famRel;
    private LocalDate famStaDate;
    private LocalDate famEndDate;

    public FamilyInfo() {
    }

    @Builder
    public FamilyInfo(String famName, LocalDate famBirthDate, String famRel, LocalDate famStaDate, LocalDate famEndDate) {
        this.famName = famName;
        this.famBirthDate = famBirthDate;
        this.famRel = famRel;
        this.famStaDate = famStaDate;
        this.famEndDate = famEndDate;
    }
}
