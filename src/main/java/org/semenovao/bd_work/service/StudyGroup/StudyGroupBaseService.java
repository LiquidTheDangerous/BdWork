package org.semenovao.bd_work.service.StudyGroup;

import org.semenovao.bd_work.domain.StudyGroup.StudyGroupBase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface StudyGroupBaseService {
    StudyGroupBase save(StudyGroupBase sgb);

    StudyGroupBase update(StudyGroupBase sgb);

    void delete(Long id);

    List<StudyGroupBase> getAll();

    Optional<StudyGroupBase> getById(Long id);

    List<StudyGroupBase> getAllByDepartmentId(Long id);
}
