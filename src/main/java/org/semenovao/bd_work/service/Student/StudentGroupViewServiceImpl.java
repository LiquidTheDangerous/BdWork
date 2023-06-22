package org.semenovao.bd_work.service.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.semenovao.bd_work.domain.Student.StudentGroup;

import java.util.List;
import java.util.Optional;

public class StudentGroupViewServiceImpl implements StudentGroupViewService {

    @PersistenceContext
    private final EntityManager em;

    public StudentGroupViewServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<StudentGroup> getAll() {
        return em.createNativeQuery("SELECT * FROM student_group", StudentGroup.class)
                .getResultList();
    }

    @Override
    public Optional<StudentGroup> getGroupByStudentId(Long studentId) {
        var Query = em.createNativeQuery("SELECT * FROM student_group WHERE student_group.student_id = :id", StudentGroup.class)
                .setParameter("id", studentId);
        var result = Query.getSingleResult();
        if (result == null) {
            return Optional.empty();
        }
        return Optional.of((StudentGroup) result);
    }


}
