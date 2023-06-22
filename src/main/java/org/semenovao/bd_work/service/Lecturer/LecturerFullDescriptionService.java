package org.semenovao.bd_work.service.Lecturer;

import org.semenovao.bd_work.domain.Lecturer.LecturerFullDescription;

import java.util.List;

public interface LecturerFullDescriptionService {
    List<LecturerFullDescription> getAll();

    List<LecturerFullDescription> getAllByDepartmentId(Long departmentId);
}
