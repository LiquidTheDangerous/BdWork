package org.semenovao.bd_work.service.Discipline;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.semenovao.bd_work.domain.Discipline.Discipline;
import org.semenovao.bd_work.domain.Discipline.DisciplineLecturerView;
import org.semenovao.bd_work.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DisciplineServiceImpl")
public class DisciplineServiceImpl implements DisciplineService {

    @PersistenceContext
    EntityManager em;

    private final DisciplineRepository disciplineRepository;

    public DisciplineServiceImpl(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public List<DisciplineLecturerView> getAllFullView() {
        return em.createNativeQuery("SELECT * FROM discipline_lecturer_view", DisciplineLecturerView.class)
                .getResultList();
    }

    @Override
    public List<Discipline> getAll() {
        return disciplineRepository.findAll();
    }

    @Override
    @Transactional
    public Discipline save(Discipline discipline) {
        disciplineRepository.insert(discipline);
        return discipline;
    }

    @Override
    @Transactional
    public Discipline update(Discipline discipline) {
        disciplineRepository.update(discipline);
        return discipline;
    }
    @Override
    @Transactional
    public void delete(Long id) {
        disciplineRepository.deleteById(id);
    }
}
