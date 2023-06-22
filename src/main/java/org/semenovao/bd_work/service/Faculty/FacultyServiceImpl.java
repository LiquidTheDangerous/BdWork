package org.semenovao.bd_work.service.Faculty;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.semenovao.bd_work.domain.Faculty.Faculty;
import org.semenovao.bd_work.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("facultyServiceImpl")
public class FacultyServiceImpl implements FacultyService {
    @PersistenceContext
    EntityManager em;

    final
    FacultyRepository facultyRepository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    @Transactional
    public Faculty save(Faculty faculty) {
        facultyRepository.insert(faculty);
        return faculty;
    }

    @Override
    @Transactional
    public Faculty update(Faculty faculty) {
        facultyRepository.update(faculty);
        return faculty;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Optional<Faculty> getById(Long id) {
        return facultyRepository.findById(id);
    }


}
