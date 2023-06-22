package org.semenovao.bd_work.domain.Student;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "student_group", schema = "courswork")
public class StudentGroup {

    @Id
    @Column(name = "student_id", nullable = false)
    private Long studentId;
    @Basic
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Basic
    @Column(name = "surname", nullable = false, length = 32)
    private String surname;
    @Basic
    @Column(name = "patronymic", nullable = true, length = 32)
    private String patronymic;
    @Basic
    @Column(name = "group_id", nullable = false)
    private Long groupId;
    @Basic
    @Column(name = "group_name", nullable = false, length = 32)
    private String groupName;
    @Basic
    @Column(name = "admission_year", nullable = false)
    private Long admissionYear;
    @Basic
    @Column(name = "group_num", nullable = false)
    private Long groupNum;
    @Basic
    @Column(name = "postfix", nullable = false, length = 4)
    private String postfix;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(Long admissionYear) {
        this.admissionYear = admissionYear;
    }

    public Long getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Long groupNum) {
        this.groupNum = groupNum;
    }

    public String getPostfix() {
        return postfix;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentGroup that = (StudentGroup) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(that.patronymic) : that.patronymic != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (admissionYear != null ? !admissionYear.equals(that.admissionYear) : that.admissionYear != null)
            return false;
        if (groupNum != null ? !groupNum.equals(that.groupNum) : that.groupNum != null) return false;
        if (postfix != null ? !postfix.equals(that.postfix) : that.postfix != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (admissionYear != null ? admissionYear.hashCode() : 0);
        result = 31 * result + (groupNum != null ? groupNum.hashCode() : 0);
        result = 31 * result + (postfix != null ? postfix.hashCode() : 0);
        return result;
    }
}
