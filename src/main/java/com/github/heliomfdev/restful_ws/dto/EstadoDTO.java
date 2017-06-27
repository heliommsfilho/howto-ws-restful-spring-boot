package com.github.heliomfdev.restful_ws.dto;

import java.io.Serializable;

public class EstadoDTO implements Serializable {

    private static final long serialVersionUID = 8645121583750134482L;

    private String nomePais;
    private String nome;
    private String sigla;
    private Integer quantidadeCidades;

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
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

    public Integer getQuantidadeCidades() {
        return quantidadeCidades;
    }

    public void setQuantidadeCidades(Integer quantidadeCidades) {
        this.quantidadeCidades = quantidadeCidades;
    }
}
