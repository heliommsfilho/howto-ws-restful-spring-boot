package com.github.heliomfdev.restful_ws.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize
public class PaisDTO implements Serializable {

    private static final long serialVersionUID = -6836083760892112332L;

    private String nome;
    private String sigla;
    private int quantidadeEstados;

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

    public Integer getQuantidadeEstados() {
        return quantidadeEstados;
    }

    public void setQuantidadeEstados(Integer quantidadeEstados) {
        this.quantidadeEstados = quantidadeEstados;
    }
}
