package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Grade.GradeControlEventTypeView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface GradeControlEventTypeViewRepository extends Repository<GradeControlEventTypeView,Long> {
    @Query(value = "SELECT * FROM grade_control_event_type_view",nativeQuery = true)
    List<GradeControlEventTypeView> findAllView();

}



