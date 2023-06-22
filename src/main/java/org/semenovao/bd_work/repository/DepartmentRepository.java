package org.semenovao.bd_work.repository;


import org.semenovao.bd_work.domain.Department.Department;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//@SqlResultSetMapping(
//        name = "DepartmentMapper",
//        classes = {
//                @ConstructorResult(
//                        targetClass = org.semenovao.bd_work.domain.Department.Department.class,
//                        columns = {
//                                @ColumnResult(name = "id", type = Long.class),
//                                @ColumnResult(name = "name", type = String.class),
//                                @ColumnResult(name = "description", type = String.class)}
//                )
//        }
//)
public interface DepartmentRepository extends Repository<Department, Long> {
    @Query(name="Department.findAll",nativeQuery = true)
    List<Department> findAll();

    //TODO: fix it
    @Query(name="Department.findAllDepartmentsByFacultyId",nativeQuery = true)
    List<Department> findAllDepartmentsByFacultyId(@Param("id") Long faculty_id);

    @Modifying
    @Query(name="Department.update",nativeQuery = true)
    void update(@Param("d") Department department);

    @Query(name="Department.existsById",nativeQuery = true)
    boolean existsById(@Param("id") Long id);

    @Query(name="Department.findById",nativeQuery = true)
    Optional<Department> findById(@Param("id") Long id);

    @Modifying
    @Query(name="Department.delete",nativeQuery = true)
    void delete(@Param("d") Department entity);

    @Modifying
    @Query(name="Department.deleteById",nativeQuery = true)
    void deleteById(@Param("id") Long id);

    @Modifying
    @Query(name="Department.insert",nativeQuery = true)
    void insert(@Param("department") Department department);

}
