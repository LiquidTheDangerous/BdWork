package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.ControlEvent.ControlEvent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ControlEventRepository extends Repository<ControlEvent,Long> {

    @Query(value="SELECT * FROM control_event",nativeQuery = true)
    List<ControlEvent> findAll();

    @Query(value = "INSERT INTO control_event(control_event_type_id, control_event_auditory_id, discipline_lecturer_study_group_id, start_date) VALUES (:#{#ce.controlEventTypeId},:#{#ce.controlEventAuditoryId},:#{#ce.disciplineLecturerStudyGroupId},:#{#ce.startDate})",nativeQuery = true)
    @Modifying
    void insert(@Param("ce") ControlEvent controlEvent);

    @Query(value = "UPDATE control_event SET control_event.control_event_auditory_id=:#{#ce.controlEventAuditoryId}, control_event.discipline_lecturer_study_group_id=:#{#ce.disciplineLecturerStudyGroupId}, control_event.control_event_type_id=:#{#ce.controlEventTypeId}, control_event.start_date=:#{#ce.startDate} WHERE control_event.id=:#{#ce.id}",nativeQuery = true)
    @Modifying
    void update(@Param("ce") ControlEvent controlEvent);

    @Query(value = "DELETE FROM control_event WHERE control_event.id=:id",nativeQuery = true)
    @Modifying
    void deleteById(@Param("id") Long id);
}
