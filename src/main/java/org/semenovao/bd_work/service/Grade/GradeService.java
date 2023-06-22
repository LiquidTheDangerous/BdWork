package org.semenovao.bd_work.service.Grade;

import org.semenovao.bd_work.domain.Grade.Grade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GradeService {
    Grade save(Grade grade);

    Grade update(Grade grade);

    void delete(Long id);

    List<Grade> getAll();
}
