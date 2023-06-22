package org.semenovao.bd_work.domain.Discipline;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "discipline_lecturer_view", schema = "courswork")
public class DisciplineLecturerView {
    @Basic
    @Column(name = "id", nullable = false)
    @Id
    private Long id;
    @Basic
    @Column(name = "lecturer_id", nullable = false)
    private Long lecturerId;
    @Basic
    @Column(name = "lecturer_surname", nullable = false, length = 32)
    private String lecturerSurname;
    @Basic
    @Column(name = "lecturer_name", nullable = false, length = 32)
    private String lecturerName;
    @Basic
    @Column(name = "lecturer_patronymic", nullable = true, length = 32)
    private String lecturerPatronymic;
    @Basic
    @Column(name = "academic_title", nullable = false, length = 32)
    private String academicTitle;
    @Basic
    @Column(name = "discipline_name", nullable = true, length = 64)
    private String disciplineName;
    @Basic
    @Column(name = "department_name", nullable = false, length = 32)
    private String departmentName;
    @Basic
    @Column(name = "faculty_name", nullable = false, length = 32)
    private String facultyName;

    public Long getId() {
        return id;
    }


    public Long getLecturerId() {
        return lecturerId;
    }


    public String getLecturerSurname() {
        return lecturerSurname;
    }


    public String getLecturerName() {
        return lecturerName;
    }


    public String getLecturerPatronymic() {
        return lecturerPatronymic;
    }


    public String getAcademicTitle() {
        return academicTitle;
    }


    public String getDisciplineName() {
        return disciplineName;
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

        DisciplineLecturerView that = (DisciplineLecturerView) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (lecturerId != null ? !lecturerId.equals(that.lecturerId) : that.lecturerId != null) return false;
        if (lecturerSurname != null ? !lecturerSurname.equals(that.lecturerSurname) : that.lecturerSurname != null)
            return false;
        if (lecturerName != null ? !lecturerName.equals(that.lecturerName) : that.lecturerName != null) return false;
        if (lecturerPatronymic != null ? !lecturerPatronymic.equals(that.lecturerPatronymic) : that.lecturerPatronymic != null)
            return false;
        if (academicTitle != null ? !academicTitle.equals(that.academicTitle) : that.academicTitle != null)
            return false;
        if (disciplineName != null ? !disciplineName.equals(that.disciplineName) : that.disciplineName != null)
            return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (facultyName != null ? !facultyName.equals(that.facultyName) : that.facultyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lecturerId != null ? lecturerId.hashCode() : 0);
        result = 31 * result + (lecturerSurname != null ? lecturerSurname.hashCode() : 0);
        result = 31 * result + (lecturerName != null ? lecturerName.hashCode() : 0);
        result = 31 * result + (lecturerPatronymic != null ? lecturerPatronymic.hashCode() : 0);
        result = 31 * result + (academicTitle != null ? academicTitle.hashCode() : 0);
        result = 31 * result + (disciplineName != null ? disciplineName.hashCode() : 0);
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
        return result;
    }
}
