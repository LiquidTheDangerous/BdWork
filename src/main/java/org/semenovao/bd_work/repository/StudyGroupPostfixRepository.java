package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.StudyGroup.StudyGroupPostfix;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudyGroupPostfixRepository extends Repository<StudyGroupPostfix, Long> {
    @Modifying
    @Query(name="StudyGroupPostfix.update",nativeQuery = true)
    void update(@Param("sgp") StudyGroupPostfix sgp);

    @Query(name="StudyGroupPostfix.existsById",nativeQuery = true)
    boolean existsById(@Param("id") Long id);

    @Query(name="StudyGroupPostfix.findAll",nativeQuery = true)
    List<StudyGroupPostfix> findAll();

    @Query(name="StudyGroupPostfix.findById",nativeQuery = true)
    Optional<StudyGroupPostfix> findById(@Param("id") Long id);

    @Modifying
    @Query(name="StudyGroupPostfix.delete",nativeQuery = true)
    void delete(@Param("sgp") StudyGroupPostfix entity);

    @Modifying
    @Query(name="StudyGroupPostfix.deleteById",nativeQuery = true)
    void deleteById(@Param("id") Long id);

    @Modifying
    @Query(name="StudyGroupPostfix.insert", nativeQuery = true)
    void insert(@Param("sgp") StudyGroupPostfix sgp);

}
