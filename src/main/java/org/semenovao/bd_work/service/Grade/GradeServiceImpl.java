package org.semenovao.bd_work.service.Grade;

import jakarta.transaction.Transactional;
import org.semenovao.bd_work.domain.Grade.Grade;
import org.semenovao.bd_work.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GradeServiceImpl")
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    @Transactional
    public Grade save(Grade grade) {
        gradeRepository.insert(grade);
        return grade;
    }

    @Override
    @Transactional
    public Grade update(Grade grade) {
        gradeRepository.update(grade);
        return grade;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }
}
