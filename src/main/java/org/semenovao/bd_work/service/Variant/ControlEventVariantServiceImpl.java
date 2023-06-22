package org.semenovao.bd_work.service.Variant;

import jakarta.transaction.Transactional;
import org.semenovao.bd_work.domain.Variant.ControlEventVariant;
import org.semenovao.bd_work.repository.ControlEventVariantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ControlEventVariantServiceImpl")
public class ControlEventVariantServiceImpl implements ControlEventVariantService {

    private final ControlEventVariantRepository controlEventVariantRepository;

    public ControlEventVariantServiceImpl(ControlEventVariantRepository controlEventVariantRepository) {
        this.controlEventVariantRepository = controlEventVariantRepository;
    }

    @Override
    @Transactional
    public ControlEventVariant save(ControlEventVariant cev) {
        this.controlEventVariantRepository.insert(cev);
        return cev;
    }

    @Override
    @Transactional
    public ControlEventVariant update(ControlEventVariant cev) {
        this.controlEventVariantRepository.update(cev);
        return cev;
    }

    @Override
    @Transactional
    public void updateVariantNum(Long id, Long variantNum) {
        controlEventVariantRepository.updateVariantNum(id, variantNum);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.controlEventVariantRepository.deleteById(id);
    }

    @Override
    public List<ControlEventVariant> getAll() {
        return controlEventVariantRepository.findAll();
    }
}
