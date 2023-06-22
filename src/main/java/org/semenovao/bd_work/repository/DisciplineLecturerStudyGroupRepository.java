package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Discipline.DisciplineLecturerStudyGroup;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DisciplineLecturerStudyGroupRepository extends Repository<DisciplineLecturerStudyGroup, Long> {
    @Query(value = "SELECT * FROM discipline_lecturer_study_group",nativeQuery = true)
    List<DisciplineLecturerStudyGroup> findAll();

    @Query(value = "INSERT INTO discipline_lecturer_study_group(discipline_lecturer_id, study_group_id) VALUES (:#{#dlsg.disciplineLecturerId},:#{#dlsg.studyGroupId})",nativeQuery = true)
    @Modifying
    void insert(@Param("dlsg") DisciplineLecturerStudyGroup disciplineLecturerStudyGroup);

    @Query(value = "UPDATE discipline_lecturer_study_group SET discipline_lecturer_study_group.discipline_lecturer_id=:#{#dlsg.disciplineLecturerId}, discipline_lecturer_study_group.study_group_id=:#{#dlsg.studyGroupId} WHERE discipline_lecturer_study_group.id=:#{#dlsg.id}",nativeQuery = true)
    @Modifying
    void update(@Param("dlsg") DisciplineLecturerStudyGroup disciplineLecturerStudyGroup);

    @Query(value = "DELETE FROM discipline_lecturer_study_group WHERE discipline_lecturer_study_group.id=:id",nativeQuery = true)
    @Modifying
    void deleteById(@Param("id") Long id);
}
