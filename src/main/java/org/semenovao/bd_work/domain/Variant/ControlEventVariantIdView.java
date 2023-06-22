package org.semenovao.bd_work.domain.Variant;

import jakarta.persistence.*;

@Entity
@Table(name = "control_event_variant_id_view", schema = "courswork")
public class ControlEventVariantIdView {
    @Basic
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "variant_num", nullable = false)
    private Long variantNum;
    @Basic
    @Column(name = "discipline_id", nullable = false)
    private Long disciplineId;
    @Basic
    @Column(name = "lecturer_id", nullable = false)
    private Long lecturerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVariantNum() {
        return variantNum;
    }

    public void setVariantNum(Long variantNum) {
        this.variantNum = variantNum;
    }

    public Long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Long disciplineId) {
        this.disciplineId = disciplineId;
    }

    public Long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControlEventVariantIdView that = (ControlEventVariantIdView) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (variantNum != null ? !variantNum.equals(that.variantNum) : that.variantNum != null) return false;
        if (disciplineId != null ? !disciplineId.equals(that.disciplineId) : that.disciplineId != null) return false;
        if (lecturerId != null ? !lecturerId.equals(that.lecturerId) : that.lecturerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (variantNum != null ? variantNum.hashCode() : 0);
        result = 31 * result + (disciplineId != null ? disciplineId.hashCode() : 0);
        result = 31 * result + (lecturerId != null ? lecturerId.hashCode() : 0);
        return result;
    }
}
