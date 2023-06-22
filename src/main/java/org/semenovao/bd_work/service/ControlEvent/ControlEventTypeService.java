package org.semenovao.bd_work.service.ControlEvent;

import org.semenovao.bd_work.domain.ControlEvent.ControlEventType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ControlEventTypeService {
    List<ControlEventType> getAll();

    void delete(Long id);

    ControlEventType update(ControlEventType cet);

    ControlEventType save(ControlEventType cet);
}
