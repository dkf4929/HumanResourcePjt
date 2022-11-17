package project.humanresource.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;
import project.humanresource.entitybase.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@SequenceGenerator(
        name = "ORG_GENERATOR",
        sequenceName = "ORGANIZATION_SEQUENCES",
        initialValue = 1, allocationSize = 50
)
public class Organization extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORG_GENERATOR")
    @Column(name = "org_id")
    private Long id;

    @ColumnDefault("000000")
    private String orgCd;
    private String orgNm;
    private Long superOrgId;
    private LocalDate orgCreateDate;
    private LocalDate orgEndDate;
}
