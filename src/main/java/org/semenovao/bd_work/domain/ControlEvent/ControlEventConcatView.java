package org.semenovao.bd_work.domain.ControlEvent;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.sql.Timestamp;

@Entity
@Immutable
@Table(name = "control_event_concat_view", schema = "courswork")
public class ControlEventConcatView {
    @Basic
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "discipline_lecturer_study_group_id", nullable = false)
    private Long disciplineLecturerStudyGroupId;
    @Basic
    @Column(name = "group_id", nullable = false)
    private Long groupId;
    @Basic
    @Column(name = "group_name", nullable = true, length = 124)
    private String groupName;
    @Basic
    @Column(name = "lecturer_id", nullable = false)
    private Long lecturerId;
    @Basic
    @Column(name = "lecturer", nullable = true, length = 177)
    private String lecturer;
    @Basic
    @Column(name = "discipline_id", nullable = false)
    private Long disciplineId;
    @Basic
    @Column(name = "discipline", nullable = true, length = 64)
    private String discipline;
    @Basic
    @Column(name = "control_event_type_id", nullable = false)
    private Long controlEventTypeId;
    @Basic
    @Column(name = "type", nullable = false, length = 32)
    private String type;
    @Basic
    @Column(name = "location_auditory_id", nullable = false)
    private Long locationAuditoryId;
    @Basic
    @Column(name = "location", nullable = true, length = 76)
    private String location;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDisciplineLecturerStudyGroupId() {
        return disciplineLecturerStudyGroupId;
    }

    public void setDisciplineLecturerStudyGroupId(Long disciplineLecturerStudyGroupId) {
        this.disciplineLecturerStudyGroupId = disciplineLecturerStudyGroupId;
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

    public Long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public Long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Long disciplineId) {
        this.disciplineId = disciplineId;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public Long getControlEventTypeId() {
        return controlEventTypeId;
    }

    public void setControlEventTypeId(Long controlEventTypeId) {
        this.controlEventTypeId = controlEventTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getLocationAuditoryId() {
        return locationAuditoryId;
    }

    public void setLocationAuditoryId(Long locationAuditoryId) {
        this.locationAuditoryId = locationAuditoryId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControlEventConcatView that = (ControlEventConcatView) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (disciplineLecturerStudyGroupId != null ? !disciplineLecturerStudyGroupId.equals(that.disciplineLecturerStudyGroupId) : that.disciplineLecturerStudyGroupId != null)
            return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (lecturerId != null ? !lecturerId.equals(that.lecturerId) : that.lecturerId != null) return false;
        if (lecturer != null ? !lecturer.equals(that.lecturer) : that.lecturer != null) return false;
        if (disciplineId != null ? !disciplineId.equals(that.disciplineId) : that.disciplineId != null) return false;
        if (discipline != null ? !discipline.equals(that.discipline) : that.discipline != null) return false;
        if (controlEventTypeId != null ? !controlEventTypeId.equals(that.controlEventTypeId) : that.controlEventTypeId != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (locationAuditoryId != null ? !locationAuditoryId.equals(that.locationAuditoryId) : that.locationAuditoryId != null)
            return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (disciplineLecturerStudyGroupId != null ? disciplineLecturerStudyGroupId.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (lecturerId != null ? lecturerId.hashCode() : 0);
        result = 31 * result + (lecturer != null ? lecturer.hashCode() : 0);
        result = 31 * result + (disciplineId != null ? disciplineId.hashCode() : 0);
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        result = 31 * result + (controlEventTypeId != null ? controlEventTypeId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (locationAuditoryId != null ? locationAuditoryId.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        return result;
    }
}
