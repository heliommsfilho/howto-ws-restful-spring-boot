package com.github.heliomfdev.restful_ws.dto;

public class PaisDTO {

    private String nome;
    private String sigla;
    private Integer quantidadeEstados;

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
