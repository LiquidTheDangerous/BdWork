package org.semenovao.bd_work.service.StudyGroup;

import org.semenovao.bd_work.domain.StudyGroup.StudyGroup;
import org.springframework.stereotype.Component;

@Component
public interface StudyGroupService {
    StudyGroup save(StudyGroup studyGroup);
}
