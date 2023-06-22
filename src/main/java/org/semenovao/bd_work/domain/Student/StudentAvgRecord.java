package org.semenovao.bd_work.domain.Student;

import jakarta.persistence.*;

import java.io.Serializable;


@Embeddable
class StudentAvgRecordId implements Serializable {
    @Column(name="id")
    Long studentId;
    @Column(name="lecturer_id")
    Long lecturerId;
    @Column(name="discipline_id")
    Long disciplineId;
}

@Entity
@Table(name = "student_avg_record", schema = "courswork")
public class StudentAvgRecord {

    @EmbeddedId
    private StudentAvgRecordId studentAvgRecordId;
    @Basic
    @Column(name = "group_id", nullable = false)
    private Long groupId;
    @Basic
    @Column(name = "student_department_id", nullable = false)
    private Long studentDepartmentId;
    @Basic
    @Column(name = "student_faculty_id", nullable = false)
    private Long studentFacultyId;
    @Basic
    @Column(name = "group", nullable = true, length = 124)
    private String group;
    @Basic
    @Column(name = "student", nullable = true, length = 98)
    private String student;

    @Basic
    @Column(name = "discipline_name", nullable = true, length = 64)
    private String disciplineName;

    @Basic
    @Column(name = "lecturer", nullable = true, length = 98)
    private String lecturer;
    @Basic
    @Column(name = "title", nullable = false, length = 32)
    private String title;
    @Basic
    @Column(name = "avg", nullable = true, precision = 3)
    private double avg;

    public Long getId() {
        return this.studentAvgRecordId.studentId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getStudentDepartmentId() {
        return studentDepartmentId;
    }

    public void setStudentDepartmentId(Long studentDepartmentId) {
        this.studentDepartmentId = studentDepartmentId;
    }

    public Long getStudentFacultyId() {
        return studentFacultyId;
    }

    public void setStudentFacultyId(Long studentFacultyId) {
        this.studentFacultyId = studentFacultyId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Long getDisciplineId() {
        return this.studentAvgRecordId.disciplineId;
    }


    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public Long getLecturerId() {
        return this.studentAvgRecordId.lecturerId;
    }


    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentAvgRecord that = (StudentAvgRecord) o;

        if (this.getId() != null ? !this.getId().equals(that.getId()) : that.getId() != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (studentDepartmentId != null ? !studentDepartmentId.equals(that.studentDepartmentId) : that.studentDepartmentId != null)
            return false;
        if (studentFacultyId != null ? !studentFacultyId.equals(that.studentFacultyId) : that.studentFacultyId != null)
            return false;
        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (student != null ? !student.equals(that.student) : that.student != null) return false;
        if (getDisciplineId() != null ? !getDisciplineId().equals(that.getDisciplineId()) : that.getDisciplineId() != null) return false;
        if (disciplineName != null ? !disciplineName.equals(that.disciplineName) : that.disciplineName != null)
            return false;
        if (getLecturerId() != null ? !getLecturerId().equals(that.getLecturerId()) : that.getLecturerId() != null) return false;
        if (lecturer != null ? !lecturer.equals(that.lecturer) : that.lecturer != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (studentDepartmentId != null ? studentDepartmentId.hashCode() : 0);
        result = 31 * result + (studentFacultyId != null ? studentFacultyId.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (getDisciplineId() != null ? getDisciplineId().hashCode() : 0);
        result = 31 * result + (disciplineName != null ? disciplineName.hashCode() : 0);
        result = 31 * result + (getLecturerId() != null ? getLecturerId().hashCode() : 0);
        result = 31 * result + (lecturer != null ? lecturer.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
