package org.semenovao.bd_work.domain.Discipline;

import jakarta.persistence.*;

@Entity
@Table(name = "discipline_lecturer_study_group", schema = "courswork")
public class DisciplineLecturerStudyGroup {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "discipline_lecturer_id", nullable = false)
    private Long disciplineLecturerId;
    @Basic
    @Column(name = "study_group_id", nullable = false)
    private Long studyGroupId;

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

    public Long getStudyGroupId() {
        return studyGroupId;
    }

    public void setStudyGroupId(Long studyGroupId) {
        this.studyGroupId = studyGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DisciplineLecturerStudyGroup that = (DisciplineLecturerStudyGroup) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (disciplineLecturerId != null ? !disciplineLecturerId.equals(that.disciplineLecturerId) : that.disciplineLecturerId != null)
            return false;
        if (studyGroupId != null ? !studyGroupId.equals(that.studyGroupId) : that.studyGroupId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (disciplineLecturerId != null ? disciplineLecturerId.hashCode() : 0);
        result = 31 * result + (studyGroupId != null ? studyGroupId.hashCode() : 0);
        return result;
    }
}
