package org.semenovao.bd_work.service.Discipline;

import org.semenovao.bd_work.domain.Discipline.DisciplineLecturer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DisciplineLecturerService {
    DisciplineLecturer save(DisciplineLecturer dl);

    DisciplineLecturer update(DisciplineLecturer dl);

    void delete(Long id);

    List<DisciplineLecturer> getAll();
}
