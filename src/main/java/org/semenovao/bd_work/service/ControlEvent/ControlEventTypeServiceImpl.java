package org.semenovao.bd_work.service.ControlEvent;

import org.semenovao.bd_work.domain.ControlEvent.ControlEventType;
import org.semenovao.bd_work.repository.ControlEventTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ControlEventTypeServiceImpl")
public class ControlEventTypeServiceImpl implements ControlEventTypeService {

    private final ControlEventTypeRepository controlEventTypeRepository;

    public ControlEventTypeServiceImpl(ControlEventTypeRepository controlEventTypeRepository) {
        this.controlEventTypeRepository = controlEventTypeRepository;
    }

    @Override
    public List<ControlEventType> getAll() {
        return controlEventTypeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        controlEventTypeRepository.deleteById(id);
    }

    @Override
    public ControlEventType update(ControlEventType cet) {
        controlEventTypeRepository.update(cet);
        return cet;
    }

    @Override
    public ControlEventType save(ControlEventType cet) {
        controlEventTypeRepository.insert(cet);
        return cet;
    }
}
