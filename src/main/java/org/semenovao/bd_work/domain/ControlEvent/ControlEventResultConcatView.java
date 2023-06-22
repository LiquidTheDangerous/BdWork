package org.semenovao.bd_work.domain.ControlEvent;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "control_event_result_concat_view", schema = "courswork")
public class ControlEventResultConcatView {
    @Basic
    @Column(name = "id", nullable = false)
    @Id
    private Long id;

    @Basic
    @Column(name="student_id")
    @Id
    private Long studentId;
    @Basic
    @Column(name = "student", nullable = true, length = 98)
    private String student;

    @Basic
    @Column(name="group_id")
    private Long groupId;
    @Basic
    @Column(name = "student_group", nullable = true, length = 124)
    private String studentGroup;
    @Basic
    @Column(name = "lecturer", nullable = true, length = 98)
    private String lecturer;
    @Basic
    @Column(name = "lecturer_group", nullable = true, length = 65)
    private String lecturerGroup;
    @Basic
    @Column(name = "location", nullable = true, length = 76)
    private String location;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;
    @Basic
    @Column(name = "discipline_name", nullable = true, length = 64)
    private String disciplineName;
    @Basic
    @Column(name = "control_event_type", nullable = false, length = 32)
    private String controlEventType;
    @Basic
    @Column(name = "variant_num", nullable = false)
    private Long variantNum;
    @Basic
    @Column(name = "grade", nullable = false, length = 32)
    private String grade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getLecturerGroup() {
        return lecturerGroup;
    }

    public void setLecturerGroup(String lecturerGroup) {
        this.lecturerGroup = lecturerGroup;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getControlEventType() {
        return controlEventType;
    }

    public void setControlEventType(String controlEventType) {
        this.controlEventType = controlEventType;
    }

    public Long getVariantNum() {
        return variantNum;
    }

    public void setVariantNum(Long variantNum) {
        this.variantNum = variantNum;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControlEventResultConcatView that = (ControlEventResultConcatView) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (student != null ? !student.equals(that.student) : that.student != null) return false;
        if (studentGroup != null ? !studentGroup.equals(that.studentGroup) : that.studentGroup != null) return false;
        if (lecturer != null ? !lecturer.equals(that.lecturer) : that.lecturer != null) return false;
        if (lecturerGroup != null ? !lecturerGroup.equals(that.lecturerGroup) : that.lecturerGroup != null)
            return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (disciplineName != null ? !disciplineName.equals(that.disciplineName) : that.disciplineName != null)
            return false;
        if (controlEventType != null ? !controlEventType.equals(that.controlEventType) : that.controlEventType != null)
            return false;
        if (variantNum != null ? !variantNum.equals(that.variantNum) : that.variantNum != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (studentGroup != null ? studentGroup.hashCode() : 0);
        result = 31 * result + (lecturer != null ? lecturer.hashCode() : 0);
        result = 31 * result + (lecturerGroup != null ? lecturerGroup.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (disciplineName != null ? disciplineName.hashCode() : 0);
        result = 31 * result + (controlEventType != null ? controlEventType.hashCode() : 0);
        result = 31 * result + (variantNum != null ? variantNum.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        return result;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
