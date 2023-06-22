package org.semenovao.bd_work.domain.ControlEvent;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.sql.Timestamp;

@Entity
@Immutable
@Table(name = "control_event_view", schema = "courswork")
public class ControlEventView {
    @Basic
    @Id
    @Column(name = "control_event_id", nullable = false)
    private Long controlEventId;
    @Basic
    @Column(name = "discipline_id", nullable = false)
    private Long disciplineId;
    @Basic
    @Column(name = "discipline_name", nullable = true, length = 64)
    private String disciplineName;
    @Basic
    @Column(name = "control_type", nullable = false, length = 32)
    private String controlType;
    @Basic
    @Column(name = "group_id", nullable = false)
    private Long groupId;
    @Basic
    @Column(name = "group_name", nullable = true, length = 58)
    private String groupName;
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
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;
    @Basic
    @Column(name = "location_id", nullable = false)
    private Long locationId;
    @Basic
    @Column(name = "location_name", nullable = false, length = 64)
    private String locationName;
    @Basic
    @Column(name = "auditory_id", nullable = false)
    private Long auditoryId;
    @Basic
    @Column(name = "auditory_number", nullable = false)
    private int auditoryNumber;
    @Basic
    @Column(name = "department_name", nullable = false, length = 32)
    private String departmentName;
    @Basic
    @Column(name = "faculty_name", nullable = false, length = 32)
    private String facultyName;

    public Long getControlEventId() {
        return controlEventId;
    }


    public Long getDisciplineId() {
        return disciplineId;
    }


    public String getDisciplineName() {
        return disciplineName;
    }


    public String getControlType() {
        return controlType;
    }


    public Long getGroupId() {
        return groupId;
    }


    public String getGroupName() {
        return groupName;
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


    public Timestamp getStartDate() {
        return startDate;
    }


    public Long getLocationId() {
        return locationId;
    }


    public String getLocationName() {
        return locationName;
    }


    public Long getAuditoryId() {
        return auditoryId;
    }


    public int getAuditoryNumber() {
        return auditoryNumber;
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

        ControlEventView that = (ControlEventView) o;

        if (auditoryNumber != that.auditoryNumber) return false;
        if (controlEventId != null ? !controlEventId.equals(that.controlEventId) : that.controlEventId != null)
            return false;
        if (disciplineId != null ? !disciplineId.equals(that.disciplineId) : that.disciplineId != null) return false;
        if (disciplineName != null ? !disciplineName.equals(that.disciplineName) : that.disciplineName != null)
            return false;
        if (controlType != null ? !controlType.equals(that.controlType) : that.controlType != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (lecturerSurname != null ? !lecturerSurname.equals(that.lecturerSurname) : that.lecturerSurname != null)
            return false;
        if (lecturerName != null ? !lecturerName.equals(that.lecturerName) : that.lecturerName != null) return false;
        if (lecturerPatronymic != null ? !lecturerPatronymic.equals(that.lecturerPatronymic) : that.lecturerPatronymic != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (locationId != null ? !locationId.equals(that.locationId) : that.locationId != null) return false;
        if (locationName != null ? !locationName.equals(that.locationName) : that.locationName != null) return false;
        if (auditoryId != null ? !auditoryId.equals(that.auditoryId) : that.auditoryId != null) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (facultyName != null ? !facultyName.equals(that.facultyName) : that.facultyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = controlEventId != null ? controlEventId.hashCode() : 0;
        result = 31 * result + (disciplineId != null ? disciplineId.hashCode() : 0);
        result = 31 * result + (disciplineName != null ? disciplineName.hashCode() : 0);
        result = 31 * result + (controlType != null ? controlType.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (lecturerSurname != null ? lecturerSurname.hashCode() : 0);
        result = 31 * result + (lecturerName != null ? lecturerName.hashCode() : 0);
        result = 31 * result + (lecturerPatronymic != null ? lecturerPatronymic.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (locationId != null ? locationId.hashCode() : 0);
        result = 31 * result + (locationName != null ? locationName.hashCode() : 0);
        result = 31 * result + (auditoryId != null ? auditoryId.hashCode() : 0);
        result = 31 * result + auditoryNumber;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (facultyName != null ? facultyName.hashCode() : 0);
        return result;
    }
}
