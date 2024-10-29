package br.com.fiap.fintech.Entities;

import java.sql.Timestamp;

public class Investimento {
    private Long id;
    private TipoInvestimento tipoInvestimento;
    private double valor;
    private Timestamp dataInicio;
    private Timestamp dataResgate;
    private int usuarioId;

    public Investimento(TipoInvestimento tipoInvestimento, double valor, Timestamp dataInicio, Timestamp dataResgate, int usuarioId) {
        this.tipoInvestimento = tipoInvestimento;
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.dataResgate = dataResgate;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoInvestimento getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(TipoInvestimento tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Timestamp getDataResgate() {
        return dataResgate;
    }

    public void setDataResgate(Timestamp dataResgate) {
        this.dataResgate = dataResgate;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
