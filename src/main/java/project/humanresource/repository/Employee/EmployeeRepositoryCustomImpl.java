package project.humanresource.repository.Employee;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import project.humanresource.dto.EmployeeInfoDto;
import project.humanresource.dto.QEmployeeInfoDto;

import javax.persistence.EntityManager;

import java.util.List;

import static project.humanresource.entity.QEmployee.*;

@Slf4j
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;

    public EmployeeRepositoryCustomImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<EmployeeInfoDto> findAllByParam(EmployeeSearchParam param, Pageable pageable) {
        List<EmployeeInfoDto> fetch = queryFactory
                .select(new QEmployeeInfoDto(employee.empBasicInfo.empNo, employee.empBasicInfo.empNm,
                        employee.empBasicInfo.hireDate, employee.organization.orgNm,
                        employee.empDetail.phoneNo, employee.empDetail.gender))
                .from(employee)
                .join(employee.organization)
                .join(employee.empDetail)
                .where(empNameEq(param.getEmpNm()), empNoEq(param.getEmpNo()), orgCdEq(param.getOrgCd()), orgNmEq(param.getOrgNm()))
                .fetch();

        log.info("data = {}", fetch);
        log.info("pageable = {}", pageable);

        return new PageImpl<>(fetch, pageable, fetch.size());
    }

    private BooleanExpression empNameEq(String empNm) {
        return empNm != null ? employee.empBasicInfo.empNm.eq(empNm) : null;
    }

    private BooleanExpression empNoEq(String empNo) {
        return empNo != null ? employee.empBasicInfo.empNo.eq(empNo) : null;
    }

    private BooleanExpression orgCdEq(String orgCd) {
        return orgCd != null ? employee.organization.orgCd.eq(orgCd) : null;
    }

    private BooleanExpression orgNmEq(String orgNm) {
        return orgNm != null ? employee.organization.orgNm.eq(orgNm) : null;
    }
}
