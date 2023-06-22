package org.semenovao.bd_work.service.Discipline;

import jakarta.transaction.Transactional;
import org.hibernate.annotations.Table;
import org.semenovao.bd_work.domain.Discipline.DisciplineLecturerStudyGroup;
import org.semenovao.bd_work.repository.DisciplineLecturerStudyGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DisciplineLecturerStudyGroupServiceImpl")
public class DisciplineLecturerStudyGroupServiceImpl implements DisciplineLecturerStudyGroupService {


    private final DisciplineLecturerStudyGroupRepository disciplineLecturerStudyGroupRepository;

    public DisciplineLecturerStudyGroupServiceImpl(DisciplineLecturerStudyGroupRepository disciplineLecturerStudyGroupRepository) {
        this.disciplineLecturerStudyGroupRepository = disciplineLecturerStudyGroupRepository;
    }

    @Override
    public List<DisciplineLecturerStudyGroup> getAll() {
        return disciplineLecturerStudyGroupRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        disciplineLecturerStudyGroupRepository.deleteById(id);
    }

    @Override
    @Transactional
    public DisciplineLecturerStudyGroup update(DisciplineLecturerStudyGroup disciplineLecturerStudyGroup) {
        disciplineLecturerStudyGroupRepository.update(disciplineLecturerStudyGroup);
        return disciplineLecturerStudyGroup;
    }

    @Override
    @Transactional
    public DisciplineLecturerStudyGroup save(DisciplineLecturerStudyGroup disciplineLecturerStudyGroup) {
        disciplineLecturerStudyGroupRepository.insert(disciplineLecturerStudyGroup);
        return disciplineLecturerStudyGroup;
    }
}
