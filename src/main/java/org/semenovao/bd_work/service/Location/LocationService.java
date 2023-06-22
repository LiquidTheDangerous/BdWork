package org.semenovao.bd_work.service.Location;

import org.semenovao.bd_work.domain.Location.Location;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LocationService {
    List<Location> getAll();
    void delete(Long id);
    Location update(Location location);

    Location save(Location location);

}
