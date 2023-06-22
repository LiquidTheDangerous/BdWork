package org.semenovao.bd_work.service.ControlEvent;
import org.semenovao.bd_work.domain.ControlEvent.ControlEventResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ControlEventResultService {
    List<ControlEventResult> getAll();

    void delete(Long id);

    ControlEventResult update(ControlEventResult controlEventResult);

    ControlEventResult save(ControlEventResult controlEventResult);
}
