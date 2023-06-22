package org.semenovao.bd_work.domain.Lecturer;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "lecturer_full_description", schema = "courswork")
public class LecturerFullDescription {
    @Basic
    @Column(name = "id", nullable = false)
    @Id
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Basic
    @Column(name = "surname", nullable = false, length = 32)
    private String surname;
    @Basic
    @Column(name = "patronimic", nullable = true, length = 32)
    private String patronimic;

    @Basic
    @Column(name="department_id")
    private Long departmentId;
    @Basic
    @Column(name = "title", nullable = false, length = 32)
    private String title;
    @Basic
    @Column(name = "department_name", nullable = false, length = 32)
    private String departmentName;
    @Basic
    @Column(name = "faculty_name", nullable = false, length = 32)
    private String facultyName;

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }


    public String getPatronimic() {
        return patronimic;
    }


    public String getTitle() {
        return title;
    }


    public String getDepartmentName() {
        return departmentName;
    }


    public String getFacultyName() {
        return facultyName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LecturerFullDescription that = (LecturerFullDescription) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (patronimic != null ? !patronimic.equals(that.patronimic) : that.patronimic != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (facultyName != null ? !facultyName.equals(that.facultyName) : that.facultyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronimic != null ? patronimic.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
        return result;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId){
        this.departmentId = departmentId;
    }
}
