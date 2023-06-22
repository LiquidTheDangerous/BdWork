package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.ControlEvent.ControlEventType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ControlEventTypeRepository extends Repository<ControlEventType,Long> {

    @Query(value = "SELECT * FROM control_event_type",nativeQuery = true)
    List<ControlEventType> findAll();

    @Query(value = "DELETE FROM control_event_type WHERE control_event_type.id=:id",nativeQuery = true)
    @Modifying
    void deleteById(Long id);

    @Query(value="UPDATE control_event_type SET control_event_type.name=:#{#cet.name} WHERE control_event_type.id=:#{#cet.id}",nativeQuery = true)
    @Modifying
    void update(@Param("cet") ControlEventType cet);

    @Query(value = "INSERT INTO control_event_type(name) values (:#{#cet.name})",nativeQuery = true)
    @Modifying
    void insert(@Param("cet") ControlEventType cet);
}
