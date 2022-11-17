package project.humanresource.embedable;

import lombok.*;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FamilyInfo {
    private String famName;
    private LocalDate famBirthDate;
    private String famRel;
    private LocalDate famStaDate;
    private LocalDate famEndDate;

}
