package org.semenovao.bd_work.service.Location;

import jakarta.transaction.Transactional;
import org.semenovao.bd_work.domain.Location.Location;
import org.semenovao.bd_work.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("LocationServiceImpl")
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Location update(Location location) {
        locationRepository.update(location);
        return location;
    }

    @Override
    @Transactional
    public Location save(Location location) {
        locationRepository.insert(location);
        return location;
    }
}
