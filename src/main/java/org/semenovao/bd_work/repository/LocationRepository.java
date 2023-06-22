package org.semenovao.bd_work.repository;

import org.semenovao.bd_work.domain.Location.Location;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends Repository<Location,Long> {

    @Query(value="SELECT * FROM location",nativeQuery = true)
    List<Location> findAll();

    @Modifying
    @Query(value = "UPDATE location SET location.name=:#{#l.name} WHERE location.id = :#{#l.id}",nativeQuery = true)
    void update(@Param("l") Location l);

    @Modifying
    @Query(value = "DELETE FROM location WHERE location.id=:id",nativeQuery = true)
    void deleteById(@Param("id") Long id);

    @Modifying
    @Query(value = "INSERT INTO location(name) VALUES (:#{#l.name})",nativeQuery = true)
    void insert(@Param("l") Location l);


}
