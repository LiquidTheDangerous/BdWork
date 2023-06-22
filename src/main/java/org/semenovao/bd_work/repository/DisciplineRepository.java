package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Discipline.Discipline;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DisciplineRepository extends Repository<Discipline,Long> {

    @Query(value="SELECT * FROM discipline",nativeQuery = true)
    List<Discipline> findAll();

    @Query(value="INSERT INTO discipline(name) VALUES (:#{#discipline.name})",nativeQuery = true)
    @Modifying
    void insert(@Param("discipline") Discipline discipline);

    @Query(value = "UPDATE discipline SET discipline.name = :#{#d.name} WHERE discipline.id=:#{#d.id}",nativeQuery = true)
    @Modifying
    void update(@Param("d") Discipline discipline);

    @Query(value = "DELETE FROM discipline WHERE discipline.id=:id",nativeQuery = true)
    @Modifying
    void deleteById(@Param("id") Long disciplineId);

}
