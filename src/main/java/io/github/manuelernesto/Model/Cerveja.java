package io.github.manuelernesto.Model;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class Cerveja {

    @NotBlank(message = "Campo SKU é Obrigatório")
    private String sku;

    @NotBlank(message = "Campo nome é Obrigatório")
    private String nome;

    @NotBlank()
    @Size(message = "Campo descrição é Obrigatório", min = 5, max = 50)
    private String descricao;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
