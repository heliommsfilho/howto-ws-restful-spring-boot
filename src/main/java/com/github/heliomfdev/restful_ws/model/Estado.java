package com.github.heliomfdev.restful_ws.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Estado implements Serializable {

    private static final long serialVersionUID = 2282038916464924631L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "uf")
    private String sigla;

    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cidade> cidades;

    @ManyToOne
    @JoinColumn(name = "pais")
    private Pais pais;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Integer getQuantidadeCidades() {
        return this.cidades.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estado estado = (Estado) o;

        if (!id.equals(estado.id)) return false;
        if (!nome.equals(estado.nome)) return false;
        if (!sigla.equals(estado.sigla)) return false;
        if (cidades != null ? !cidades.equals(estado.cidades) : estado.cidades != null) return false;
        return pais.equals(estado.pais);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + sigla.hashCode();
        result = 31 * result + (cidades != null ? cidades.hashCode() : 0);
        result = 31 * result + pais.hashCode();
        return result;
    }
}
