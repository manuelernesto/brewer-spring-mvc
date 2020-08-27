package io.github.manuelernesto.Model;


import org.hibernate.validator.constraints.NotBlank;

public class Cerveja {

    @NotBlank(message = "Campo SKU é Obrigatório")
    private String sku;
//    @NotBlank(message = "Campo nome é Obrigatório")
    private String nome;

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
}
