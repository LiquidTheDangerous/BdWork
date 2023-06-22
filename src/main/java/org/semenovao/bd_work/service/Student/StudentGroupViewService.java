package org.semenovao.bd_work.service.Student;

import org.semenovao.bd_work.domain.Student.StudentGroup;

import java.util.List;
import java.util.Optional;

public interface StudentGroupViewService {
    List<StudentGroup> getAll();

    Optional<StudentGroup> getGroupByStudentId(Long studentId);
}
