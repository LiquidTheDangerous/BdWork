package org.semenovao.bd_work.service.Variant;

import org.semenovao.bd_work.domain.Variant.ControlEventVariant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ControlEventVariantService {
    ControlEventVariant save(ControlEventVariant cev);

    ControlEventVariant update(ControlEventVariant cev);

    void updateVariantNum(Long id, Long variantNum);

    void delete(Long id);

    List<ControlEventVariant> getAll();
}
