package org.semenovao.bd_work.service.Discipline;

import org.semenovao.bd_work.domain.Discipline.Discipline;
import org.semenovao.bd_work.domain.Discipline.DisciplineLecturerView;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface DisciplineService {
    List<DisciplineLecturerView> getAllFullView();
    List<Discipline> getAll();
    Discipline save(Discipline discipline);
    Discipline update(Discipline discipline);
    void delete(Long id);
}
