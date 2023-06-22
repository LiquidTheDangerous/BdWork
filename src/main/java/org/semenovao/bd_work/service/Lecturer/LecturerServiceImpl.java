package org.semenovao.bd_work.service.Lecturer;

import jakarta.transaction.Transactional;
import org.semenovao.bd_work.domain.Lecturer.Lecturer;
import org.semenovao.bd_work.repository.LecturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LecturerService")
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository repository;

    public LecturerServiceImpl(LecturerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Lecturer> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Lecturer save(Lecturer lecturer) {
        repository.insert(lecturer);
        return lecturer;
    }
}
