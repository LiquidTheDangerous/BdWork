package org.semenovao.bd_work.service.StudyGroup;

import org.semenovao.bd_work.domain.StudyGroup.StudyGroupPostfix;
import org.semenovao.bd_work.repository.StudyGroupPostfixRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StudyGroupPostfixServiceImpl")
public class StudyGroupPostfixServiceImpl implements StudyGroupPostfixService {

    private final StudyGroupPostfixRepository repository;

    public StudyGroupPostfixServiceImpl(StudyGroupPostfixRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StudyGroupPostfix> getAll() {
        return  repository.findAll();
    }
}
