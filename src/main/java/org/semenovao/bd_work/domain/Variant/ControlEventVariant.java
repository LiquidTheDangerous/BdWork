package org.semenovao.bd_work.domain.Variant;

import jakarta.persistence.*;

@Entity
@Table(name = "control_event_variant", schema = "courswork")
public class ControlEventVariant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "discipline_lecturer_id", nullable = false)
    private Long disciplineLecturerId;
    @Basic
    @Column(name = "variant_num", nullable = false)
    private Long variantNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDisciplineLecturerId() {
        return disciplineLecturerId;
    }

    public void setDisciplineLecturerId(Long disciplineLecturerId) {
        this.disciplineLecturerId = disciplineLecturerId;
    }

    public Long getVariantNum() {
        return variantNum;
    }

    public void setVariantNum(Long variantNum) {
        this.variantNum = variantNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControlEventVariant that = (ControlEventVariant) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (disciplineLecturerId != null ? !disciplineLecturerId.equals(that.disciplineLecturerId) : that.disciplineLecturerId != null)
            return false;
        if (variantNum != null ? !variantNum.equals(that.variantNum) : that.variantNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (disciplineLecturerId != null ? disciplineLecturerId.hashCode() : 0);
        result = 31 * result + (variantNum != null ? variantNum.hashCode() : 0);
        return result;
    }
}
