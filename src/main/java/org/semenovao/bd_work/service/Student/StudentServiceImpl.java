package org.semenovao.bd_work.service.Student;

import jakarta.transaction.Transactional;
import org.semenovao.bd_work.domain.Student.Student;
import org.semenovao.bd_work.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {


    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Student save(Student student) {
        repository.insert(student);
        return student;
    }

    @Override
    @Transactional
    public Student update(Student student) {
        repository.update(student);
        return student;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Student> getById(Long id) {
        return repository.findById(id);
    }
}
