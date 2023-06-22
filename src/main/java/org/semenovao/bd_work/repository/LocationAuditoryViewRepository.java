package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Location.LocationAuditoryView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LocationAuditoryViewRepository extends Repository<LocationAuditoryView,Long> {

    @Query(value = "SELECT * FROM location_auditory_view",nativeQuery = true)
    List<LocationAuditoryView> findAll();
}
