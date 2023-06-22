package org.semenovao.bd_work.service.Student;


import org.semenovao.bd_work.domain.Student.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface StudentService {
    Student save(Student student);
    Student update(Student student);
    void delete(Long id);
    List<Student> getAll();
    Optional<Student> getById(Long id);

}
