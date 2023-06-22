package org.semenovao.bd_work.service.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.semenovao.bd_work.domain.Department.Department;
import org.semenovao.bd_work.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("departmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository repository;
    @PersistenceContext
    EntityManager em;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Department save(Department department) {
        repository.insert(department);
        return department;
    }

    @Override
    @Transactional
    public Department update(Department department) {
        repository.update(department);
        return department;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Department> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Department> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Department> getAllByFacultyId(Long facultyId) {
        return repository.findAllDepartmentsByFacultyId(facultyId);
    }


}
