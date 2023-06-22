package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Variant.ControlEventVariant;
import org.semenovao.bd_work.domain.Variant.ControlEventVariantView;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ControlEventVariantViewRepository extends Repository<ControlEventVariant,Long> {
    @Query(value = "SELECT * FROM control_event_variant_view",nativeQuery = true)
    List<ControlEventVariantView> findAll();
}
