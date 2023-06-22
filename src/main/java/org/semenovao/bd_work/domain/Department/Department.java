package org.semenovao.bd_work.domain.Department;


import jakarta.persistence.*;

@Entity(name = "Department")
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;

//    @ManyToOne
//    @JoinColumn(name="faculty_id",referencedColumnName = "id",nullable = false)
//    private Faculty faculty;

    @Column(name="faculty_id",nullable = false)
    private Long facultyId;

    public Department(){}

    public Department(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }
}