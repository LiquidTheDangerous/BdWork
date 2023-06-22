package org.semenovao.bd_work.domain.Variant;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "control_event_variant_view", schema = "courswork")
public class ControlEventVariantView {
    @Basic
    @Id
    @Column(name = "variant_id", nullable = false)
    private Long variantId;
    @Basic
    @Column(name = "variant_num", nullable = false)
    private Integer variantNum;

    @Basic
    @Column(name="discipline_id")
    private Long disciplineId;

    @Basic
    @Column(name = "discipline_name", nullable = true, length = 64)
    private String disciplineName;

    @Basic
    @Column(name="lecturer_id")
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
    @Column(name = "department_name", nullable = false, length = 32)
    private String departmentName;
    @Basic
    @Column(name = "faculty_name", nullable = false, length = 32)
    private String facultyName;

    public Long getVariantId() {
        return variantId;
    }

    public void setVariantId(Long variantId) {
        this.variantId = variantId;
    }

    public Integer getVariantNum() {
        return variantNum;
    }

    public void setVariantNum(Integer variantNum) {
        this.variantNum = variantNum;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getLecturerSurname() {
        return lecturerSurname;
    }

    public void setLecturerSurname(String lecturerSurname) {
        this.lecturerSurname = lecturerSurname;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getLecturerPatronymic() {
        return lecturerPatronymic;
    }

    public void setLecturerPatronymic(String lecturerPatronymic) {
        this.lecturerPatronymic = lecturerPatronymic;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControlEventVariantView that = (ControlEventVariantView) o;

        if (variantId != null ? !variantId.equals(that.variantId) : that.variantId != null) return false;
        if (variantNum != null ? !variantNum.equals(that.variantNum) : that.variantNum != null) return false;
        if (disciplineName != null ? !disciplineName.equals(that.disciplineName) : that.disciplineName != null)
            return false;
        if (lecturerSurname != null ? !lecturerSurname.equals(that.lecturerSurname) : that.lecturerSurname != null)
            return false;
        if (lecturerName != null ? !lecturerName.equals(that.lecturerName) : that.lecturerName != null) return false;
        if (lecturerPatronymic != null ? !lecturerPatronymic.equals(that.lecturerPatronymic) : that.lecturerPatronymic != null)
            return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (facultyName != null ? !facultyName.equals(that.facultyName) : that.facultyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = variantId != null ? variantId.hashCode() : 0;
        result = 31 * result + (variantNum != null ? variantNum.hashCode() : 0);
        result = 31 * result + (disciplineName != null ? disciplineName.hashCode() : 0);
        result = 31 * result + (lecturerSurname != null ? lecturerSurname.hashCode() : 0);
        result = 31 * result + (lecturerName != null ? lecturerName.hashCode() : 0);
        result = 31 * result + (lecturerPatronymic != null ? lecturerPatronymic.hashCode() : 0);
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
        return result;
    }

    public Long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Long disciplineId) {
        this.disciplineId = disciplineId;
    }

    public Long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }
}
