package org.semenovao.bd_work.service.Location;

import org.semenovao.bd_work.domain.Location.LocationAuditory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LocationAuditoryService {

    List<LocationAuditory> getAll();

    void delete(Long id);

    LocationAuditory update(LocationAuditory locationAuditory);

    LocationAuditory save(LocationAuditory locationAuditory);
}
