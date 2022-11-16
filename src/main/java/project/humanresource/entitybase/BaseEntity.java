package project.humanresource.entitybase;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity extends BaseDateEntity {
    @LastModifiedBy
    private Integer modifiedBy;

    @CreatedBy
    @Column(updatable = false)
    private int createdBy;
}
