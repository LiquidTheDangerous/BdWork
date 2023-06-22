package org.semenovao.bd_work.domain.StudyGroup;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "group_avg_record", schema = "courswork")
public class GroupAvgRecord {
    @Basic

    @Column(name = "faculty_id", nullable = false)
    private Long facultyId;
    @Basic
    @Column(name = "faculty_name", nullable = false, length = 32)
    private String facultyName;
    @Basic
    @Column(name = "department_id", nullable = false)
    private Long departmentId;
    @Basic
    @Column(name = "department_name", nullable = false, length = 32)
    private String departmentName;
    @Basic
    @Id
    @Column(name = "group_id", nullable = false)
    private Long groupId;
    @Basic
    @Column(name = "group_name", nullable = true, length = 58)
    private String groupName;
    @Basic
    @Column(name = "avg_record", nullable = true, precision = 0)
    private Double avgRecord;

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public Double getAvgRecord() {
        return avgRecord;
    }

    public void setAvgRecord(Double avgRecord) {
        this.avgRecord = avgRecord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupAvgRecord that = (GroupAvgRecord) o;

        if (facultyId != null ? !facultyId.equals(that.facultyId) : that.facultyId != null) return false;
        if (facultyName != null ? !facultyName.equals(that.facultyName) : that.facultyName != null) return false;
        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (avgRecord != null ? !avgRecord.equals(that.avgRecord) : that.avgRecord != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = facultyId != null ? facultyId.hashCode() : 0;
        result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (avgRecord != null ? avgRecord.hashCode() : 0);
        return result;
    }
}
