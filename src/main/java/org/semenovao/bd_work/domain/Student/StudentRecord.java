package org.semenovao.bd_work.domain.Student;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "student_record", schema = "courswork")
public class StudentRecord {
    @Basic
    @Id
    @Column(name = "student_id", nullable = false)
    private Long studentId;
    @Basic
    @Column(name = "department name", nullable = false, length = 32)
    private String departmentName;
    @Basic
    @Column(name = "faculty_name", nullable = false, length = 32)
    private String facultyName;
    @Basic
    @Column(name = "group_name", nullable = true, length = 58)
    private String groupName;
    @Basic
    @Column(name = "group_id", nullable = false)
    private Long groupId;
    @Basic
    @Column(name = "department_id", nullable = false)
    private Long departmentId;
    @Basic
    @Column(name = "faculty_id", nullable = false)
    private Long facultyId;
    @Basic
    @Column(name = "surname", nullable = false, length = 32)
    private String surname;
    @Basic
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Basic
    @Column(name = "patronymic", nullable = true, length = 32)
    private String patronymic;
    @Basic
    @Column(name = "record", nullable = true, precision = 0)
    private Double record;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Double getRecord() {
        return record;
    }

    public void setRecord(Double record) {
        this.record = record;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentRecord that = (StudentRecord) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (facultyName != null ? !facultyName.equals(that.facultyName) : that.facultyName != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
        if (facultyId != null ? !facultyId.equals(that.facultyId) : that.facultyId != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (patronymic != null ? !patronymic.equals(that.patronymic) : that.patronymic != null) return false;
        if (record != null ? !record.equals(that.record) : that.record != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (facultyId != null ? facultyId.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (record != null ? record.hashCode() : 0);
        return result;
    }
}
