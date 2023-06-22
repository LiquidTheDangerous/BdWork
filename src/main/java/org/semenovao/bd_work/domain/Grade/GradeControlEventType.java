package org.semenovao.bd_work.domain.Grade;

import jakarta.persistence.*;

@Entity
@Table(name = "grade_control_event_type", schema = "courswork", catalog = "")
public class GradeControlEventType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "grade_id", nullable = false)
    private Long gradeId;
    @Basic
    @Column(name = "control_event_type_id", nullable = false)
    private Long controlEventTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getControlEventTypeId() {
        return controlEventTypeId;
    }

    public void setControlEventTypeId(Long controlEventTypeId) {
        this.controlEventTypeId = controlEventTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GradeControlEventType that = (GradeControlEventType) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (gradeId != null ? !gradeId.equals(that.gradeId) : that.gradeId != null) return false;
        if (controlEventTypeId != null ? !controlEventTypeId.equals(that.controlEventTypeId) : that.controlEventTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (gradeId != null ? gradeId.hashCode() : 0);
        result = 31 * result + (controlEventTypeId != null ? controlEventTypeId.hashCode() : 0);
        return result;
    }
}
