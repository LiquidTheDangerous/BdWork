package org.semenovao.bd_work.service.Discipline;

import jakarta.transaction.Transactional;
import org.semenovao.bd_work.domain.Discipline.DisciplineLecturer;
import org.semenovao.bd_work.repository.DisciplineLecturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DisciplineLecturerServiceImpl")
public class DisciplineLecturerServiceImpl implements DisciplineLecturerService {

    private final DisciplineLecturerRepository disciplineLecturerRepository;

    public DisciplineLecturerServiceImpl(DisciplineLecturerRepository disciplineLecturerRepository) {
        this.disciplineLecturerRepository = disciplineLecturerRepository;
    }

    @Override
    @Transactional
    public DisciplineLecturer save(DisciplineLecturer dl) {
        disciplineLecturerRepository.insert(dl);
        return dl;
    }

    @Override
    @Transactional
    public DisciplineLecturer update(DisciplineLecturer dl) {
        disciplineLecturerRepository.update(dl);
        return dl;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        disciplineLecturerRepository.deleteById(id);
    }

    @Override
    public List<DisciplineLecturer> getAll() {
        return disciplineLecturerRepository.findAll();
    }
}
