package project.humanresource.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.humanresource.dto.EmployeeDto;
import project.humanresource.embedable.EmpBasicInfo;
import project.humanresource.entity.Employee;
import project.humanresource.service.EmployeeService;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employee/add")
    public long add(@RequestBody @Validated EmployeeDto dto) {
        return employeeService.save(dto);
    }

}
