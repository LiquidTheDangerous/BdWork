package org.semenovao.bd_work.domain.Lecturer;

import jakarta.persistence.*;

@Entity
public class Lecturer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "department_id", nullable = false)
    private Long departmentId;
    @Basic
    @Column(name = "academic_title_id", nullable = false)
    private Long academicTitleId;
    @Basic
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Basic
    @Column(name = "surname", nullable = false, length = 32)
    private String surname;
    @Basic
    @Column(name = "patronymic", nullable = true, length = 32)
    private String patronymic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getAcademicTitleId() {
        return academicTitleId;
    }

    public void setAcademicTitleId(Long academicTitleId) {
        this.academicTitleId = academicTitleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lecturer lecturer = (Lecturer) o;

        if (id != null ? !id.equals(lecturer.id) : lecturer.id != null) return false;
        if (departmentId != null ? !departmentId.equals(lecturer.departmentId) : lecturer.departmentId != null)
            return false;
        if (academicTitleId != null ? !academicTitleId.equals(lecturer.academicTitleId) : lecturer.academicTitleId != null)
            return false;
        if (name != null ? !name.equals(lecturer.name) : lecturer.name != null) return false;
        if (surname != null ? !surname.equals(lecturer.surname) : lecturer.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(lecturer.patronymic) : lecturer.patronymic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (academicTitleId != null ? academicTitleId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        return result;
    }
}
