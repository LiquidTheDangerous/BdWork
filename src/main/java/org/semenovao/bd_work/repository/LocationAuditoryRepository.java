package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Location.LocationAuditory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationAuditoryRepository extends Repository<LocationAuditory,Long> {
    @Query(value = "SELECT * FROM location_auditory",nativeQuery = true)
    List<LocationAuditory> findAll();

    @Modifying
    @Query(value = "INSERT INTO location_auditory(location_id, auditory_number) VALUES (:#{#la.locationId},:#{#la.auditoryNumber})",nativeQuery = true)
    void insert(@Param("la") LocationAuditory locationAuditory);

    @Modifying
    @Query(value = "UPDATE location_auditory SET location_auditory.auditory_number = :#{#la.auditoryNumber}, location_auditory.location_id=:#{#la.locationId} WHERE location_auditory.id = :#{#la.id}",nativeQuery = true)
    void update(@Param("la") LocationAuditory locationAuditory);

    @Modifying
    @Query(value = "DELETE FROM location_auditory WHERE location_auditory.id=:id",nativeQuery = true)
    void deleteById(@Param("id") Long id);
}
