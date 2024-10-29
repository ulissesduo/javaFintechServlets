package br.com.fiap.fintech.Entities;
//funcionoooooooooooooooooooooooooooooooouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu
public class InvestmentType {
    private Long id;
    private String description;

    public InvestmentType(Long id, String description) {
        this.id = id;
        this.description = description;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}