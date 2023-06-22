package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Grade.Grade;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GradeRepository extends Repository<Grade,Long> {

    @Query(value = "SELECT * FROM grade", nativeQuery = true)
    List<Grade> findAll();

    @Query(value = "UPDATE grade SET grade.name=:#{#g.name}, grade.weight_coefficient=:#{#grade.weightCoefficient} WHERE grade.id=:#{#g.id}",nativeQuery = true)
    @Modifying
    void update(@Param("g") Grade grade);


    @Modifying
    @Query(value = "DELETE FROM grade WHERE grade.id=:id",nativeQuery = true)
    void deleteById(@Param("id") Long id);

    @Modifying
    @Query(value = "INSERT INTO grade(name, weight_coefficient) VALUES (:#{#g.name}, :#{#g.weightCoefficient})",nativeQuery = true)
    void insert(@Param("g") Grade g);
}
