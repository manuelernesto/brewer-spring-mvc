package io.github.manuelernesto.Model;


import org.hibernate.validator.constraints.NotBlank;

public class Cerveja {

    @NotBlank(message = "Campo SKU é Obrigatório")
    private String sku;
    @NotBlank(message = "Campo nome é Obrigatório")
    private String nome;

}
