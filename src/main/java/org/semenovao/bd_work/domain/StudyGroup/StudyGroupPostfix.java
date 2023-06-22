package org.semenovao.bd_work.domain.StudyGroup;

import jakarta.persistence.*;

@Entity
@Table(name="study_group_postfix")
public class StudyGroupPostfix {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="postfix_name")
    private String postfixName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostfixName() {
        return postfixName;
    }

    public void setPostfixName(String postfixName) {
        this.postfixName = postfixName;
    }
}
