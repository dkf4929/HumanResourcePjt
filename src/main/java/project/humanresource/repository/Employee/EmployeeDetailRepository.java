package project.humanresource.repository.Employee;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.humanresource.dto.EmployeeDetailDto;
import project.humanresource.dto.QEmployeeDetailDto;
import project.humanresource.entity.QEmployee;

import javax.persistence.EntityManager;

import java.util.List;

import static project.humanresource.entity.QEmployee.*;

@Repository
public class EmployeeDetailRepository {

    private final EntityManager entityManager;
    private JPAQueryFactory queryFactory;

    @Autowired
    public EmployeeDetailRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    public List<EmployeeDetailDto> empDetInfo(Long empId) {
        return queryFactory.
                select(new QEmployeeDetailDto(
                        employee.empDetail.birthDate,
                        employee.empDetail.gender,
                        employee.empDetail.phoneNo,
                        employee.empDetail.homeAddress,
                        employee.empDetail.hobby,
                        employee.empDetail.intMail,
                        employee.empDetail.extMail,
                        employee.employeeFamilies
                ))
                .from(employee)
                .join(employee.employeeFamilies)
                .join(employee.empDetail)
                .where(employee.id.eq(empId))
                .fetch();

    }
}
