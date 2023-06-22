package org.semenovao.bd_work.domain.Department;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "department_faculty", schema = "courswork")
@Immutable
public class DepartmentFaculty {
    @Id
    @Basic
    @Column(name = "department_id", nullable = false)
    private Long departmentId;
    @Basic
    @Column(name = "department_name", nullable = false, length = 32)
    private String departmentName;
    @Basic
    @Column(name = "department_description", nullable = false, length = 64)
    private String departmentDescription;
    @Basic
    @Column(name = "faculty_name", nullable = false, length = 32)
    private String facultyName;

    @Basic
    @Column(name="faculty_id")
    private Long facultyId;

    public Long getDepartmentId() {
        return departmentId;
    }


    public String getDepartmentName() {
        return departmentName;
    }


    public String getDepartmentDescription() {
        return departmentDescription;
    }


    public String getFacultyName() {
        return facultyName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentFaculty that = (DepartmentFaculty) o;

        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (departmentDescription != null ? !departmentDescription.equals(that.departmentDescription) : that.departmentDescription != null)
            return false;
        if (facultyName != null ? !facultyName.equals(that.facultyName) : that.facultyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentId != null ? departmentId.hashCode() : 0;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (departmentDescription != null ? departmentDescription.hashCode() : 0);
        result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
        return result;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }
}
