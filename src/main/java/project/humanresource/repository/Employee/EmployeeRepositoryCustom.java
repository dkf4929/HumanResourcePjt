package project.humanresource.repository.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.humanresource.dto.EmployeeInfoDto;

public interface EmployeeRepositoryCustom {
    Page<EmployeeInfoDto> findAllByParam(EmployeeSearchParam param, Pageable pageable);
}
