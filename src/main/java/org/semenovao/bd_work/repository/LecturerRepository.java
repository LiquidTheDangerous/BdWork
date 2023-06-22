package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Lecturer.Lecturer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LecturerRepository extends Repository<Lecturer,Long> {

    @Query(value = "INSERT INTO lecturer(department_id, academic_title_id, name, surname, patronymic) VALUES (:#{#lecturer.departmentId},:#{#lecturer.academicTitleId},:#{#lecturer.name},:#{#lecturer.surname},:#{#lecturer.patronymic})",nativeQuery = true)
    @Modifying
    void insert(@Param("lecturer") Lecturer lecturer);

    @Query(value = "SELECT * FROM lecturer",nativeQuery = true)
    List<Lecturer> findAll();
}
