package org.semenovao.bd_work.service.StudyGroup;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.semenovao.bd_work.domain.StudyGroup.StudyGroupBase;
import org.semenovao.bd_work.repository.StudyGroupBaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("StudyGroupBaseImpl")
public class StudyGroupBaseServiceImpl implements StudyGroupBaseService {

    final StudyGroupBaseRepository repository;
    @PersistenceContext
    EntityManager em;

    public StudyGroupBaseServiceImpl(StudyGroupBaseRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public StudyGroupBase save(StudyGroupBase sgb) {
        repository.insert(sgb);
        return sgb;
    }

    @Override
    @Transactional
    public StudyGroupBase update(StudyGroupBase sgb) {
        repository.update(sgb);
        return sgb;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<StudyGroupBase> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<StudyGroupBase> getById(Long id)
    {
        return repository.findById(id);
    }

    @Override
    public List<StudyGroupBase> getAllByDepartmentId(Long id) {
        return repository.findAllByDepartmentId(id);
    }
}
