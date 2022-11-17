package project.humanresource.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.humanresource.dto.EmployeeDetailDto;
import project.humanresource.dto.EmployeeDto;
import project.humanresource.dto.EmployeeInfoDto;
import project.humanresource.repository.Employee.EmployeeSearchParam;
import project.humanresource.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public long add(@RequestBody @Validated EmployeeDto dto) {
        return employeeService.save(dto);
    }

    @GetMapping
    public Page<EmployeeInfoDto> findAllByParam(Pageable pageable, @RequestBody EmployeeSearchParam param) {
        return employeeService.findAllByParam(param, pageable);
    }

    @GetMapping("/{empId}")
    public EmployeeInfoDto findById(@PathVariable Long empId) {
        return employeeService.findById(empId);
    }

    @GetMapping("/{empId}/detail")
    public List<EmployeeDetailDto> EmpDetInfo(@PathVariable Long empId) {
        return employeeService.EmpDetInfo(empId);
    }
}
