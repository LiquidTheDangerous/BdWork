package org.semenovao.bd_work.domain.StudyGroup;

import jakarta.persistence.*;

@Entity
@Table(name="study_group")
public class StudyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Long id;
    @Column(name = "study_group_postfix_id", nullable = false)
    private Long studyGroupPostfixId;

    @Column(name = "study_group_base_id", nullable = false)
    private Long studyGroupBaseId;

    @Column(name="admission_year",nullable = false)
    private Integer admissionYear;

    @Column(name="group_num",nullable=false)
    private Integer groupNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudyGroupPostfixId() {
        return studyGroupPostfixId;
    }

    public void setStudyGroupPostfixId(Long studyGroupPostfixId) {
        this.studyGroupPostfixId = studyGroupPostfixId;
    }

    public Long getStudyGroupBaseId() {
        return studyGroupBaseId;
    }

    public Integer getAdmissionYear() {
        return admissionYear;
    }

    public Integer getGroupNum() {
        return groupNum;
    }
}
