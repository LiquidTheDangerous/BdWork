package org.semenovao.bd_work.service.Lecturer;

import org.semenovao.bd_work.domain.Lecturer.Lecturer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LecturerService {

    List<Lecturer> getAll();
    Lecturer save(Lecturer lecturer);
}
