package project.humanresource.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.humanresource.entity.Employee;

import java.lang.reflect.Member;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Page<Member> findAllBy();
}
