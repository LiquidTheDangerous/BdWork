package org.semenovao.bd_work.service.ControlEvent;

import jakarta.transaction.Transactional;
import org.semenovao.bd_work.domain.ControlEvent.ControlEventResult;
import org.semenovao.bd_work.repository.ControlEventResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ControlEventResultServiceImpl")
public class ControlEventResultServiceImpl implements ControlEventResultService {

    private final ControlEventResultRepository controlEventResultRepository;

    public ControlEventResultServiceImpl(ControlEventResultRepository controlEventResultRepository) {
        this.controlEventResultRepository = controlEventResultRepository;
    }

    @Override
    public List<ControlEventResult> getAll() {
        return controlEventResultRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        controlEventResultRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ControlEventResult update(ControlEventResult controlEventResult) {
        controlEventResultRepository.update(controlEventResult);
        return controlEventResult;
    }

    @Override
    @Transactional
    public ControlEventResult save(ControlEventResult controlEventResult) {
        controlEventResultRepository.insert(controlEventResult);
        return controlEventResult;
    }
}
