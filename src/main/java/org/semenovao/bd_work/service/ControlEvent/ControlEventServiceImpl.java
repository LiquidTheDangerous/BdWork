package org.semenovao.bd_work.service.ControlEvent;

import jakarta.transaction.Transactional;
import org.semenovao.bd_work.domain.ControlEvent.ControlEvent;
import org.semenovao.bd_work.repository.ControlEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ControlEventServiceImpl")
public class ControlEventServiceImpl implements ControlEventService {

    private final ControlEventRepository controlEventRepository;

    public ControlEventServiceImpl(ControlEventRepository controlEventRepository) {
        this.controlEventRepository = controlEventRepository;
    }

    @Override
    public List<ControlEvent> getAll() {
        return controlEventRepository.findAll();
    }

    @Override
    @Transactional
    public ControlEvent update(ControlEvent controlEvent) {
        controlEventRepository.update(controlEvent);
        return controlEvent;
    }

    @Override
    @Transactional
    public ControlEvent save(ControlEvent controlEvent) {
        controlEventRepository.insert(controlEvent);
        return controlEvent;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        controlEventRepository.deleteById(id);
    }
}
