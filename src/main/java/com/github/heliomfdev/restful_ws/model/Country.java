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
 * Country entity.
 * */
@Entity(name = "pais")
public class Country implements Serializable {

    private static final long serialVersionUID = 6036414602334726140L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "sigla")
    private String abbreviation;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<State> states;

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

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public Integer getQuantidadeEstados() {
        return this.states.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (!id.equals(country.id)) return false;
        if (!name.equals(country.name)) return false;
        if (!abbreviation.equals(country.abbreviation)) return false;
        return states != null ? states.equals(country.states) : country.states == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + abbreviation.hashCode();
        result = 31 * result + (states != null ? states.hashCode() : 0);
        return result;
    }
}
