package com.github.heliomfdev.restful_ws.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Hélio Márcio Filho
 * @see <a href="https://github.com/heliomf-dev">Visit my GitHub</a>
 * @since 1.0
 * @version 1.0
 *
 * State entity.
 * */
@Entity(name = "estado")
public class State implements Serializable {

    private static final long serialVersionUID = 2282038916464924631L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "uf")
    private String abbreviation;

    @OneToMany(mappedBy = "state", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<City> cities;

    @ManyToOne
    @JoinColumn(name = "pais")
    private Country country;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getQuantidadeCidades() {
        return this.cities.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        if (!id.equals(state.id)) return false;
        if (!name.equals(state.name)) return false;
        if (!abbreviation.equals(state.abbreviation)) return false;
        if (cities != null ? !cities.equals(state.cities) : state.cities != null) return false;
        return country.equals(state.country);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + abbreviation.hashCode();
        result = 31 * result + (cities != null ? cities.hashCode() : 0);
        result = 31 * result + country.hashCode();
        return result;
    }
}
