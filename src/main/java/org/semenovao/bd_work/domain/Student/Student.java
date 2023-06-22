package org.semenovao.bd_work.domain.Student;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "study_group_id", nullable = false)
    private Long studyGroupId;
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Column(name = "surname", nullable = false, length = 32)
    private String surname;
    @Column(name = "patronymic", nullable = true, length = 32)
    private String patronymic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudyGroupId() {
        return studyGroupId;
    }

    public void setStudyGroupId(Long studyGroupId) {
        this.studyGroupId = studyGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(studyGroupId, student.studyGroupId) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(patronymic, student.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studyGroupId, name, surname, patronymic);
    }
}
