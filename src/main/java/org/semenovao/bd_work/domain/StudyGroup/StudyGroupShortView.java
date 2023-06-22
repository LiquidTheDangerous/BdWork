package org.semenovao.bd_work.domain.StudyGroup;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="group_short_name")
public class StudyGroupShortView {
    @Id
    @Column(name="group_id")
    private Long id;

    @Column(name="group_name")
    private String name;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

}
