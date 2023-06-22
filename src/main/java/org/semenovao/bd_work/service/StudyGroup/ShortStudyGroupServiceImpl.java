package org.semenovao.bd_work.service.StudyGroup;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.semenovao.bd_work.domain.StudyGroup.StudyGroupShortView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ShortStudyGroupServiceImpl")
public class ShortStudyGroupServiceImpl implements ShortStudyGroupService {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<StudyGroupShortView> getAllShortGroups() {
        return em.createNativeQuery("SELECT * FROM group_short_name", StudyGroupShortView.class)
                .getResultList();
    }
}
