package org.semenovao.bd_work.service.Discipline;

import org.semenovao.bd_work.domain.Discipline.DisciplineLecturerStudyGroup;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DisciplineLecturerStudyGroupService {
    List<DisciplineLecturerStudyGroup> getAll();

    void delete(Long id);
    DisciplineLecturerStudyGroup update(DisciplineLecturerStudyGroup disciplineLecturerStudyGroup);

    DisciplineLecturerStudyGroup save(DisciplineLecturerStudyGroup disciplineLecturerStudyGroup);
}
