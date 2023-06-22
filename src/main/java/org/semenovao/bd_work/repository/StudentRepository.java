package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Student.Student;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends Repository<Student,Long> {
    @Modifying
    @Query(name="Student.update",nativeQuery = true)
    void update(@Param("s") Student student);
    @Query(name="Student.existsById",nativeQuery = true)
    boolean existsById(@NonNull @Param("id") Long id);

    @NonNull
    @Query(name="Student.findAll",nativeQuery = true)
    List<Student> findAll();
    @NonNull
    @Query(name="Student.findById",nativeQuery = true)
    Optional<Student> findById(@NonNull @Param("id") Long id);
    @Modifying
    @Query(name="Student.delete",nativeQuery = true)
    void delete(@NonNull @Param("s") Student entity);
    @Modifying
    @Query(name="Student.deleteById",nativeQuery = true)
    void deleteById(@NonNull @Param("id") Long id);

    @Modifying
    @Query(name="Student.insert",nativeQuery = true)
    void insert(@NonNull @Param("s") Student student);
}
