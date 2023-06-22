package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Lecturer.AcademicTitle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface AcademicTitleRepository extends Repository<AcademicTitle, Long> {

    @Query(value="SELECT * FROM academic_title",nativeQuery = true)
    List<AcademicTitle> findAll();

    @Query(value = "SELECT * FROM academic_title WHERE academic_title.id=:id",nativeQuery = true)
    Optional<AcademicTitle> findById(@NonNull @Param("id") Long id);
    @Modifying
    @Query(value = "INSERT INTO academic_title(name) value (:#{#title.name})",nativeQuery = true)
    void insert(@Param("title") AcademicTitle academicTitle);

    @Modifying
    @Query(value = "DELETE FROM academic_title WHERE academic_title.id = :id",nativeQuery = true)
    void deleteById(@NonNull @Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE academic_title set academic_title.name=:#{#title.name} WHERE  academic_title.id = :#{#title.id}",nativeQuery = true)
    void update(@NonNull @Param("title") AcademicTitle title);
}
