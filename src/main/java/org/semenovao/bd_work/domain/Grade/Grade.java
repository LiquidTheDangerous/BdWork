package org.semenovao.bd_work.domain.Grade;

import jakarta.persistence.*;

@Entity
@Table(name = "grade", schema = "courswork")
public class Grade {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Basic
    @Column(name = "weight_coefficient", nullable = false, precision = 0)
    private double weightCoefficient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeightCoefficient() {
        return weightCoefficient;
    }

    public void setWeightCoefficient(double weightCoefficient) {
        this.weightCoefficient = weightCoefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade fullGrade = (Grade) o;

        if (Double.compare(fullGrade.weightCoefficient, weightCoefficient) != 0) return false;
        if (id != null ? !id.equals(fullGrade.id) : fullGrade.id != null) return false;
        if (name != null ? !name.equals(fullGrade.name) : fullGrade.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(weightCoefficient);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
