package org.semenovao.bd_work.domain.Location;

import jakarta.persistence.*;

@Entity
@Table(name = "location_auditory", schema = "courswork")
public class LocationAuditory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "location_id", nullable = false)
    private Long locationId;
    @Basic
    @Column(name = "auditory_number", nullable = false)
    private int auditoryNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public int getAuditoryNumber() {
        return auditoryNumber;
    }

    public void setAuditoryNumber(int auditoryNumber) {
        this.auditoryNumber = auditoryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationAuditory that = (LocationAuditory) o;

        if (auditoryNumber != that.auditoryNumber) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (locationId != null ? !locationId.equals(that.locationId) : that.locationId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (locationId != null ? locationId.hashCode() : 0);
        result = 31 * result + auditoryNumber;
        return result;
    }
}
