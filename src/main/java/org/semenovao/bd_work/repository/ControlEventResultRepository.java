package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.ControlEvent.ControlEventResult;
import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface ControlEventResultRepository extends Repository<ControlEventResult,Long> {

    @Query(value="SELECT * FROM control_event_result",nativeQuery = true)
    List<ControlEventResult> findAll();

    @Modifying
    @Query(value = "DELETE FROM control_event_result WHERE control_event_result.id=:id",nativeQuery = true)
    void deleteById(@Param("id") Long id);

    @Modifying
    @Query(value="UPDATE control_event_result SET control_event_result.student_id = :#{#cer.studentId}, control_event_result.control_event_id= :#{#cer.controlEventId}, control_event_result.control_event_variant_id=:#{#cer.controlEventVariantId}, control_event_result.grade_id=:#{#cer.gradeId} WHERE control_event_result.id=:#{#cer.id}",nativeQuery = true)
    void update(@Param("cer") ControlEventResult controlEventResult);

    @Modifying
    @Query(value = "INSERT INTO control_event_result(student_id, control_event_id, control_event_variant_id, grade_id) VALUES (:#{#cer.studentId}, :#{#cer.controlEventId},:#{#cer.controlEventVariantId},:#{#cer.gradeId})",nativeQuery = true)
    void insert(@Param("cer") ControlEventResult controlEventResult);

}
