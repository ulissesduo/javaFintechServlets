package br.com.fiap.fintech.Entities;
//funcionoooooooooooooooooooooooooooooooouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu
public class InvestmentType {
    private Integer id;
    private String description;

    public InvestmentType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}