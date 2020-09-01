package io.github.manuelernesto.Model;

public enum Origem {
    NACIONAL("Nacional"),
    INTERNACIONAL("Internacional");

    private final String descricao;

    Origem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
