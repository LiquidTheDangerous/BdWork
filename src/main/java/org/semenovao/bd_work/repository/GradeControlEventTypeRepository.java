package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Grade.GradeControlEventType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface GradeControlEventTypeRepository extends Repository<GradeControlEventType,Long> {

    @Query(value="SELECT * FROM grade_control_event_type",nativeQuery=true)
    List<GradeControlEventType> findAll();
}
