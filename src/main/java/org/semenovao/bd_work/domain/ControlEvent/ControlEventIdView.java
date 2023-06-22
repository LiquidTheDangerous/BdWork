package org.semenovao.bd_work.domain.ControlEvent;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.sql.Timestamp;

@Entity
@Immutable
@Table(name = "control_event_id_view", schema = "courswork")
public class ControlEventIdView {
    @Basic
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "study_group_id", nullable = false)
    private Long studyGroupId;
    @Basic
    @Column(name = "discipline_id", nullable = false)
    private Long disciplineId;
    @Basic
    @Column(name = "lecturer_id", nullable = false)
    private Long lecturerId;
    @Basic
    @Column(name = "location_id", nullable = false)
    private Long locationId;
    @Basic
    @Column(name = "auditory_id", nullable = false)
    private Long auditoryId;
    @Basic
    @Column(name = "type_id", nullable = false)
    private Long typeId;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    public Long getId() {
        return id;
    }


    public Long getStudyGroupId() {
        return studyGroupId;
    }


    public Long getDisciplineId() {
        return disciplineId;
    }


    public Long getLecturerId() {
        return lecturerId;
    }


    public Long getLocationId() {
        return locationId;
    }


    public Long getAuditoryId() {
        return auditoryId;
    }


    public Long getTypeId() {
        return typeId;
    }


    public Timestamp getStartDate() {
        return startDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControlEventIdView that = (ControlEventIdView) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (studyGroupId != null ? !studyGroupId.equals(that.studyGroupId) : that.studyGroupId != null) return false;
        if (disciplineId != null ? !disciplineId.equals(that.disciplineId) : that.disciplineId != null) return false;
        if (lecturerId != null ? !lecturerId.equals(that.lecturerId) : that.lecturerId != null) return false;
        if (locationId != null ? !locationId.equals(that.locationId) : that.locationId != null) return false;
        if (auditoryId != null ? !auditoryId.equals(that.auditoryId) : that.auditoryId != null) return false;
        if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (studyGroupId != null ? studyGroupId.hashCode() : 0);
        result = 31 * result + (disciplineId != null ? disciplineId.hashCode() : 0);
        result = 31 * result + (lecturerId != null ? lecturerId.hashCode() : 0);
        result = 31 * result + (locationId != null ? locationId.hashCode() : 0);
        result = 31 * result + (auditoryId != null ? auditoryId.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        return result;
    }
}
