package org.semenovao.bd_work.service.StudyGroup;

import org.semenovao.bd_work.domain.StudyGroup.StudyGroupPostfix;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudyGroupPostfixService {
    List<StudyGroupPostfix> getAll();

}
