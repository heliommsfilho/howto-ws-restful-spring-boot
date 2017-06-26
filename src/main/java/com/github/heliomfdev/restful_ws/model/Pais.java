package com.github.heliomfdev.restful_ws.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Pais implements Serializable {

    private static final long serialVersionUID = 450736027805253438L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String sigla;

//    private Integer quantidadeEstados;

    @OneToMany(mappedBy = "pais", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Estado> estados;

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

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public Integer getQuantidadeEstados() {
        return this.estados.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pais pais = (Pais) o;

        if (!id.equals(pais.id)) return false;
        if (!nome.equals(pais.nome)) return false;
        if (!sigla.equals(pais.sigla)) return false;
        return estados != null ? estados.equals(pais.estados) : pais.estados == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + sigla.hashCode();
        result = 31 * result + (estados != null ? estados.hashCode() : 0);
        return result;
    }
}
