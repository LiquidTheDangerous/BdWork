package org.semenovao.bd_work.service.ControlEvent;

import org.semenovao.bd_work.domain.ControlEvent.ControlEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ControlEventService {
    List<ControlEvent> getAll();

    ControlEvent update(ControlEvent controlEvent);

    ControlEvent save(ControlEvent controlEvent);

    void delete(Long id);
}
