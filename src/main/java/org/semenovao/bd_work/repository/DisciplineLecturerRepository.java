package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Discipline.DisciplineLecturer;
import org.semenovao.bd_work.domain.Discipline.DisciplineLecturerView;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DisciplineLecturerRepository extends Repository<DisciplineLecturer,Long> {

    @Query(value="SELECT * FROM discipline_lecturer",nativeQuery = true)
    List<DisciplineLecturer> findAll();
    @Modifying
    @Query(value = "INSERT INTO discipline_lecturer(lecturer_id, discipline_id) VALUES (:#{#dl.lecturerId}, :#{#dl.disciplineId}) ",nativeQuery = true)
    void insert(@Param("dl") DisciplineLecturer dl);
    @Modifying
    @Query(value = "DELETE FROM discipline_lecturer WHERE discipline_lecturer.id=:id",nativeQuery = true)
    void deleteById(@Param("id") Long id);
    @Modifying
    @Query(value="UPDATE discipline_lecturer SET discipline_lecturer.lecturer_id=:#{#dl.lecturerId}, discipline_lecturer.discipline_id=:#{#dl.disciplineId} WHERE discipline_lecturer.id=:#{#dl.id}",nativeQuery = true)
    void update(@Param("dl") DisciplineLecturer dl);
}
