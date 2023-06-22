package org.semenovao.bd_work.service.Lecturer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.semenovao.bd_work.domain.Lecturer.LecturerFullDescription;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("LecturerFullDescriptionServiceImpl")
public class LecturerFullDescriptionServiceImpl implements LecturerFullDescriptionService {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<LecturerFullDescription> getAll() {
        Query q = em.createNativeQuery("SELECT * FROM lecturer_full_description", LecturerFullDescription.class);
        return q.getResultList();
    }

    @Override
    public List<LecturerFullDescription> getAllByDepartmentId(Long departmentId) {
        return em
                .createNativeQuery("SELECT * FROM lecturer_full_description WHERE lecturer_full_description.department_id = :id", LecturerFullDescription.class)
                .setParameter("id", departmentId)
                .getResultList();
    }
}
