package com.github.heliomfdev.restful_ws.dto;

import java.io.Serializable;

public class CidadeDTO implements Serializable{

    private String nomePais;
    private String nomeEstado;
    private String nome;

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
