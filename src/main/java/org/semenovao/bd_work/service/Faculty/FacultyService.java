package org.semenovao.bd_work.service.Faculty;

import org.semenovao.bd_work.domain.Faculty.Faculty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface FacultyService {
    Faculty save(Faculty faculty);

    Faculty update(Faculty faculty);

    void delete(Long id);
    List<Faculty> getAll();

    Optional<Faculty> getById(Long id);
}
