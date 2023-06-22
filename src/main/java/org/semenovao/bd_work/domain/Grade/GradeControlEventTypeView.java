package org.semenovao.bd_work.domain.Grade;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;


@Embeddable
class GradeControlEventTypeId implements Serializable {
    @Column(name="grade_id")
    Long gradeId;

    @Column(name="control_event_id")
    Long controlEventId;
}

@Entity
@Immutable
@Table(name = "grade_control_event_type_view", schema = "courswork")
public class GradeControlEventTypeView {
    @EmbeddedId
    GradeControlEventTypeId id;
    @Basic
    @Column(name = "control_event_name", nullable = false, length = 32)
    private String controlEventName;
    @Basic
    @Column(name = "grade_name", nullable = false, length = 32)
    private String gradeName;
    @Basic
    @Column(name = "grade_weight_coefficient", nullable = false, precision = 0)
    private double gradeWeightCoefficient;

    public String getControlEventName() {
        return controlEventName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public Long getGradeId() {
        return id.gradeId;
    }

    public double getGradeWeightCoefficient() {
        return gradeWeightCoefficient;
    }
    public Long getControlEventId() {
        return id.controlEventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GradeControlEventTypeView that = (GradeControlEventTypeView) o;

        if (Double.compare(that.gradeWeightCoefficient, gradeWeightCoefficient) != 0) return false;
        if (controlEventName != null ? !controlEventName.equals(that.controlEventName) : that.controlEventName != null)
            return false;
        if (gradeName != null ? !gradeName.equals(that.gradeName) : that.gradeName != null) return false;
        if (id.gradeId != null ? !id.gradeId.equals(that.id.gradeId) : that.id.gradeId != null) return false;
        if (id.controlEventId != null ? !id.controlEventId.equals(that.id.controlEventId) : that.id.controlEventId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = controlEventName != null ? controlEventName.hashCode() : 0;
        result = 31 * result + (gradeName != null ? gradeName.hashCode() : 0);
        result = 31 * result + (id.gradeId != null ? id.gradeId.hashCode() : 0);
        temp = Double.doubleToLongBits(gradeWeightCoefficient);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (id.controlEventId != null ? id.controlEventId.hashCode() : 0);
        return result;
    }
}
