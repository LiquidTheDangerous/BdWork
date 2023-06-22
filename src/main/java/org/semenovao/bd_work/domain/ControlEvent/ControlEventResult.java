package org.semenovao.bd_work.domain.ControlEvent;

import jakarta.persistence.*;

@Entity
@Table(name = "control_event_result", schema = "courswork")
public class ControlEventResult {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "student_id", nullable = false)
    private Long studentId;
    @Basic
    @Column(name = "control_event_id", nullable = false)
    private Long controlEventId;
    @Basic
    @Column(name = "control_event_variant_id", nullable = false)
    private Long controlEventVariantId;
    @Basic
    @Column(name = "grade_id", nullable = false)
    private Long gradeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getControlEventId() {
        return controlEventId;
    }

    public void setControlEventId(Long controlEventId) {
        this.controlEventId = controlEventId;
    }

    public Long getControlEventVariantId() {
        return controlEventVariantId;
    }

    public void setControlEventVariantId(Long controlEventVariantId) {
        this.controlEventVariantId = controlEventVariantId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControlEventResult that = (ControlEventResult) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (controlEventId != null ? !controlEventId.equals(that.controlEventId) : that.controlEventId != null)
            return false;
        if (controlEventVariantId != null ? !controlEventVariantId.equals(that.controlEventVariantId) : that.controlEventVariantId != null)
            return false;
        if (gradeId != null ? !gradeId.equals(that.gradeId) : that.gradeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        result = 31 * result + (controlEventId != null ? controlEventId.hashCode() : 0);
        result = 31 * result + (controlEventVariantId != null ? controlEventVariantId.hashCode() : 0);
        result = 31 * result + (gradeId != null ? gradeId.hashCode() : 0);
        return result;
    }
}
