package data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Country {
    @Id
    @Column(name = "country_id", columnDefinition = "smallint(5) unsigned")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte id;

    @Column(name = "country", length = 50, nullable = false)
    private String name;

    @Column(name = "last_update",
            columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy = "country")
    private List<City> cities = new ArrayList<>();

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Country{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastUpdate=" + lastUpdate +
            '}';
    }
}
