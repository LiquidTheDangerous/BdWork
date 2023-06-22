package org.semenovao.bd_work.service.Location;

import jakarta.transaction.Transactional;
import org.hibernate.annotations.Table;
import org.semenovao.bd_work.domain.Location.LocationAuditory;
import org.semenovao.bd_work.repository.LocationAuditoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("LocationAuditoryServiceImpl")
public class LocationAuditoryServiceImpl implements LocationAuditoryService {

    private final LocationAuditoryRepository locationAuditoryRepository;

    public LocationAuditoryServiceImpl(LocationAuditoryRepository locationAuditoryRepository) {
        this.locationAuditoryRepository = locationAuditoryRepository;
    }

    @Override
    public List<LocationAuditory> getAll() {
        return locationAuditoryRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        locationAuditoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public LocationAuditory update(LocationAuditory locationAuditory) {
        locationAuditoryRepository.update(locationAuditory);
        return locationAuditory;
    }

    @Override
    @Transactional
    public LocationAuditory save(LocationAuditory locationAuditory) {
        locationAuditoryRepository.insert(locationAuditory);
        return locationAuditory;
    }
}
