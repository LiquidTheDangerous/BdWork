package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Variant.ControlEventVariant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ControlEventVariantRepository extends Repository<ControlEventVariant,Long> {

    @Modifying
    @Query(value = "INSERT INTO control_event_variant(discipline_lecturer_id, variant_num) VALUES (:#{#cev.disciplineLecturerId},:#{#cev.variantNum})",nativeQuery = true)
    void insert(@Param("cev") ControlEventVariant cev);

    @Modifying
    @Query(value = "DELETE FROM control_event_variant WHERE control_event_variant.id=:id",nativeQuery = true)
    void deleteById(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE control_event_variant SET control_event_variant.discipline_lecturer_id=:#{#cev.disciplineLecturerId}, control_event_variant.variant_num=:#{#cev.variantNum} WHERE control_event_variant.id=:#{#cev.id}",nativeQuery = true)
    void update(@Param("cev") ControlEventVariant cev);

    @Modifying
    @Query(value = "UPDATE control_event_variant SET control_event_variant.variant_num=:num WHERE control_event_variant.id=:id",nativeQuery = true)
    void updateVariantNum(@Param("id") Long id, @Param("num") Long variantNum);

    @Query(value = "SELECT * FROM control_event_variant",nativeQuery = true)
    List<ControlEventVariant> findAll();

}
