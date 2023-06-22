package org.semenovao.bd_work.domain.Discipline;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "discipline_lecturer_group_view", schema = "courswork")
public class DisciplineLecturerGroupView {
    @Basic
    @Column(name = "id", nullable = false)
    @Id
    private Long id;
    @Basic
    @Column(name = "group_id", nullable = false)
    private Long groupId;
    @Basic
    @Column(name = "group_name", nullable = true, length = 58)
    private String groupName;
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
    @Column(name = "lecturer_patrinymic", nullable = true, length = 32)
    private String lecturerPatrinymic;
    @Basic
    @Column(name = "discipline_id", nullable = false)
    private Long disciplineId;
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


    public Long getGroupId() {
        return groupId;
    }


    public String getGroupName() {
        return groupName;
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


    public String getLecturerPatrinymic() {
        return lecturerPatrinymic;
    }


    public Long getDisciplineId() {
        return disciplineId;
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

        DisciplineLecturerGroupView that = (DisciplineLecturerGroupView) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (lecturerId != null ? !lecturerId.equals(that.lecturerId) : that.lecturerId != null) return false;
        if (lecturerSurname != null ? !lecturerSurname.equals(that.lecturerSurname) : that.lecturerSurname != null)
            return false;
        if (lecturerName != null ? !lecturerName.equals(that.lecturerName) : that.lecturerName != null) return false;
        if (lecturerPatrinymic != null ? !lecturerPatrinymic.equals(that.lecturerPatrinymic) : that.lecturerPatrinymic != null)
            return false;
        if (disciplineId != null ? !disciplineId.equals(that.disciplineId) : that.disciplineId != null) return false;
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
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (lecturerId != null ? lecturerId.hashCode() : 0);
        result = 31 * result + (lecturerSurname != null ? lecturerSurname.hashCode() : 0);
        result = 31 * result + (lecturerName != null ? lecturerName.hashCode() : 0);
        result = 31 * result + (lecturerPatrinymic != null ? lecturerPatrinymic.hashCode() : 0);
        result = 31 * result + (disciplineId != null ? disciplineId.hashCode() : 0);
        result = 31 * result + (disciplineName != null ? disciplineName.hashCode() : 0);
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
        return result;
    }
}
