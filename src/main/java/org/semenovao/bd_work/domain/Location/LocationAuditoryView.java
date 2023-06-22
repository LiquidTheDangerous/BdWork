package org.semenovao.bd_work.domain.Location;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;

@Embeddable
class LocationAuditoryViewId implements Serializable {
    @Column(name="location_id")
    Long locationId;

    @Column(name="auditory_number")
    int auditoryNumber;
}

@Entity
@Table(name = "location_auditory_view", schema = "courswork")
@Immutable
public class LocationAuditoryView {

    @EmbeddedId
    private LocationAuditoryViewId locationId;
    @Basic
    @Column(name = "location_name", nullable = false, length = 64)
    private String locationName;

    public Long getLocationId() {
        return locationId.locationId;
    }


    public String getLocationName() {
        return locationName;
    }


    public int getAuditoryNumber() {
        return locationId.auditoryNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationAuditoryView that = (LocationAuditoryView) o;

        if (locationId.auditoryNumber != that.locationId.auditoryNumber) return false;
        if (locationId != null ? !locationId.equals(that.locationId) : that.locationId != null) return false;
        if (locationName != null ? !locationName.equals(that.locationName) : that.locationName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = locationId != null ? locationId.hashCode() : 0;
        result = 31 * result + (locationName != null ? locationName.hashCode() : 0);
        result = 31 * result + locationId.auditoryNumber;
        return result;
    }
}
