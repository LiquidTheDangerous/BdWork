package org.semenovao.bd_work.service.Department;


import org.semenovao.bd_work.domain.Department.Department;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DepartmentService {
    Department save(Department department);

    Department update(Department department);

    void delete(Long id);

    List<Department> getAll();

    Optional<Department> getById(Long id);

    List<Department> getAllByFacultyId(Long facultyId);

}
