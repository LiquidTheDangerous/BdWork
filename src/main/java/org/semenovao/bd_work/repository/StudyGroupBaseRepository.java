package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.StudyGroup.StudyGroupBase;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudyGroupBaseRepository extends Repository<StudyGroupBase, Long> {
    @Modifying
    @Query(name="StudyGroupBase.update",nativeQuery = true)
    void update(@Param("sgb") StudyGroupBase sgb);

    @Query(name="StudyGroupBase.existsById",nativeQuery = true)
    boolean existsById(@Param("id") Long id);

    @Query(name="StudyGroupBase.findAll",nativeQuery = true)
    List<StudyGroupBase> findAll();

    @Query(name="StudyGroupBase.findById",nativeQuery = true)
    Optional<StudyGroupBase> findById(@Param("id") Long id);

    @Query(name="StudyGroupBase.findAllByDepartmentId",nativeQuery = true)
    List<StudyGroupBase> findAllByDepartmentId(@Param("departmentId") Long departmentId);

    @Modifying
    @Query(name="StudyGroupBase.delete",nativeQuery = true)
    void delete(@Param("sgb") StudyGroupBase entity);

    @Modifying
    @Query(name="StudyGroupBase.deleteById",nativeQuery = true)
    void deleteById(@Param("id") Long id);

    @Modifying
    @Query(name="StudyGroupBase.insert",nativeQuery = true)
    void insert(@Param("sgb") StudyGroupBase sgb);

}
