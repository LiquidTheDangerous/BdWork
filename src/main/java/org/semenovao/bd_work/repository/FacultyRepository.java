package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Faculty.Faculty;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FacultyRepository extends Repository<Faculty, Long> {
    @Modifying
    @Query(name="Faculty.update",nativeQuery = true)
    void update(@Param("f") Faculty faculty);
    @Query(name="Faculty.existsById",nativeQuery = true)
    boolean existsById(@Param("id") Long id);
    @Query(name="Faculty.findAll",nativeQuery = true)
    List<Faculty> findAll();
    @Query(name="Faculty.findById",nativeQuery = true)
    Optional<Faculty> findById(@Param("id") Long id);
    @Modifying
    @Query(name="Faculty.delete",nativeQuery = true)
    void delete(@Param("f") Faculty entity);
    @Modifying
    @Query(name="Faculty.deleteById",nativeQuery = true)
    void deleteById(@Param("id") Long id);
    @Modifying
    @Query(name="Faculty.insert",nativeQuery = true)
    void insert(@Param("faculty") Faculty faculty);
}
