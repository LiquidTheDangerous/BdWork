package org.semenovao.bd_work.service.StudyGroup;

import jakarta.transaction.Transactional;
import org.semenovao.bd_work.domain.StudyGroup.StudyGroup;
import org.semenovao.bd_work.repository.StudyGroupRepository;
import org.springframework.stereotype.Service;

@Service("StudyGroupServiceImpl")
public class StudyGroupServiceImpl implements StudyGroupService {

    private final StudyGroupRepository studyGroupRepository;

    public StudyGroupServiceImpl(StudyGroupRepository studyGroupRepository) {
        this.studyGroupRepository = studyGroupRepository;
    }

    @Override
    @Transactional
    public StudyGroup save(StudyGroup studyGroup) {
        studyGroupRepository.insert(studyGroup);
        return studyGroup;
    }
}
