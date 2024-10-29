package br.com.fiap.fintech.Entities;

public enum TipoInvestimento {
    STOCK("Stocks"),
    BONDS("Bounds"),
    TESTE("Teste");

    private final String description;

    TipoInvestimento(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
