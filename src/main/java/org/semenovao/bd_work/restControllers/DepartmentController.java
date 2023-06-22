package org.semenovao.bd_work.restControllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.semenovao.bd_work.domain.Department.Department;
import org.semenovao.bd_work.domain.Department.DepartmentFaculty;
import org.semenovao.bd_work.repository.DepartmentRepository;
import org.semenovao.bd_work.service.Department.DepartmentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    final DepartmentService service;
    final DepartmentRepository repository;

    @PersistenceContext
    EntityManager em;

    public DepartmentController(@Qualifier("departmentServiceImpl") DepartmentService service, DepartmentRepository repository) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/getAll")
    List<Department> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{id}")
    Optional<Department> getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @GetMapping("/getAllByFacultyId/{faculty_id}")
    List<Department> getAllByFacultyId(@PathVariable("faculty_id") Long faculty_id) {
        return service.getAllByFacultyId(faculty_id);
    }

    @GetMapping("/fullDescription/getAll")
    List<DepartmentFaculty> getAllFullDescription() {
        return em.createNativeQuery("SELECT * FROM department_faculty", DepartmentFaculty.class).getResultList();
    }

    @GetMapping("/fullDescription/getAllByFacultyId")
    List<DepartmentFaculty> getAllFullDescriptionByFacultyId(@RequestParam("facultyId") Long facultyId) {
        return em
                .createNativeQuery("SELECT * FROM department_faculty WHERE faculty_id=:id", DepartmentFaculty.class)
                .setParameter("id", facultyId)
                .getResultList();
    }

    @DeleteMapping("/deleteById/{id}")
    ResponseEntity<Department> deleteById(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Department> update(@PathVariable("id") Long id, @RequestBody Department department) {

        department.setId(id);
        service.update(department);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Department> create(@RequestBody Department faculty) {
        var result = service.save(faculty);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
