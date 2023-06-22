package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.StudyGroup.StudyGroup;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudyGroupRepository extends Repository<StudyGroup, Long> {
    @Modifying
    @Query(name="StudyGroup.update",nativeQuery = true)
    void update(@Param("sg") StudyGroup sg);

    @Query(name="StudyGroup.existsById",nativeQuery = true)
    boolean existsById(@Param("id") Long id);

    @Query(name="StudyGroup.findAll",nativeQuery = true)
    List<StudyGroup> findAll();

    @Query(name="StudyGroup.findById",nativeQuery = true)
    Optional<StudyGroup> findById(@Param("id") Long id);

    @Modifying
    @Query(name="StudyGroup.delete",nativeQuery = true)
    void delete(@Param("sg") StudyGroup entity);

    @Modifying
    @Query(name="StudyGroup.deleteById",nativeQuery = true)
    void deleteById(@Param("id") Long id);

    @Modifying
    @Query(name="StudyGroup.insert",nativeQuery = true)
    void insert(@Param("sg") StudyGroup sg);
}
