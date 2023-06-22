package org.semenovao.bd_work.domain.ControlEvent;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "control_event", schema = "courswork")
public class ControlEvent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "control_event_type_id", nullable = false)
    private Long controlEventTypeId;
    @Basic
    @Column(name = "control_event_auditory_id", nullable = false)
    private Long controlEventAuditoryId;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;
    @Basic
    @Column(name = "discipline_lecturer_study_group_id", nullable = false)
    private Long disciplineLecturerStudyGroupId;

    public Object getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getControlEventTypeId() {
        return controlEventTypeId;
    }

    public void setControlEventTypeId(Long controlEventTypeId) {
        this.controlEventTypeId = controlEventTypeId;
    }

    public Long getControlEventAuditoryId() {
        return controlEventAuditoryId;
    }

    public void setControlEventAuditoryId(Long controlEventAuditoryId) {
        this.controlEventAuditoryId = controlEventAuditoryId;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Long getDisciplineLecturerStudyGroupId() {
        return disciplineLecturerStudyGroupId;
    }

    public void setDisciplineLecturerStudyGroupId(Long disciplineLecturerStudyGroupId) {
        this.disciplineLecturerStudyGroupId = disciplineLecturerStudyGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControlEvent that = (ControlEvent) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (controlEventTypeId != null ? !controlEventTypeId.equals(that.controlEventTypeId) : that.controlEventTypeId != null)
            return false;
        if (controlEventAuditoryId != null ? !controlEventAuditoryId.equals(that.controlEventAuditoryId) : that.controlEventAuditoryId != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (disciplineLecturerStudyGroupId != null ? !disciplineLecturerStudyGroupId.equals(that.disciplineLecturerStudyGroupId) : that.disciplineLecturerStudyGroupId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (controlEventTypeId != null ? controlEventTypeId.hashCode() : 0);
        result = 31 * result + (controlEventAuditoryId != null ? controlEventAuditoryId.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (disciplineLecturerStudyGroupId != null ? disciplineLecturerStudyGroupId.hashCode() : 0);
        return result;
    }
}
