package com.github.heliomfdev.restful_ws.dto;

public class PaisDto {

    private String paisNome;
    private String paisSigla;
    private String paisQuantidadeEstados;

    public String getPaisNome() {
        return paisNome;
    }

    public void setPaisNome(String paisNome) {
        this.paisNome = paisNome;
    }

    public String getPaisSigla() {
        return paisSigla;
    }

    public void setPaisSigla(String paisSigla) {
        this.paisSigla = paisSigla;
    }

    public String getPaisQuantidadeEstados() {
        return paisQuantidadeEstados;
    }

    public void setPaisQuantidadeEstados(String paisQuantidadeEstados) {
        this.paisQuantidadeEstados = paisQuantidadeEstados;
    }
}
