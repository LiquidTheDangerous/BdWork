package org.semenovao.bd_work.domain.Discipline;

import jakarta.persistence.*;

@Entity
@Table(name = "discipline_lecturer", schema = "courswork")
public class DisciplineLecturer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "lecturer_id", nullable = false)
    private Long lecturerId;
    @Basic
    @Column(name = "discipline_id", nullable = false)
    private Long disciplineId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public Long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Long disciplineId) {
        this.disciplineId = disciplineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DisciplineLecturer that = (DisciplineLecturer) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (lecturerId != null ? !lecturerId.equals(that.lecturerId) : that.lecturerId != null) return false;
        if (disciplineId != null ? !disciplineId.equals(that.disciplineId) : that.disciplineId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lecturerId != null ? lecturerId.hashCode() : 0);
        result = 31 * result + (disciplineId != null ? disciplineId.hashCode() : 0);
        return result;
    }
}
