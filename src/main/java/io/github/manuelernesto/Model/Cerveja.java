package io.github.manuelernesto.Model;


import io.github.manuelernesto.validation.SKU;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "cerveja")
public class Cerveja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @SKU
    @NotBlank(message = "Campo SKU é Obrigatório.")
    private String sku;

    @NotBlank(message = "Campo nome é Obrigatório.")
    private String nome;

    @NotBlank(message = "Campo descrição é Obrigatório.")
    @Size(message = "O tamanho da descrição deve estar entre 5 e 50.", min = 5, max = 50)
    private String descricao;

    @NotNull(message = "O preço é obrigatório")
    @DecimalMin("0.01")
    @DecimalMax(value = "9999999.99", message = "O preço deve ser menor que 9.999.999,99 AOA")
    private BigDecimal valor;

    @DecimalMax(value = "100.0", message = "Teor Alcóolico deve ser menor que 100")
    @NotNull(message = "Teor Alcóolico é obrigatório")
    @Column(name = "teor_alcoolico")
    private BigDecimal teorAlcoolico;

    @NotNull(message = "A comissão é obrigatório")
    @DecimalMax(value = "100.0", message = "Comissão deve ser menor ou igual 100")
    private BigDecimal comissao;

    @NotNull(message = "A quantidade em estoque é obrigatório")
    @Max(value = 9999, message = "A quantidade em estoque deve ser menos que 9.999")
    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    @NotNull(message = "A origem é obrigatório")
    @Enumerated(EnumType.STRING)
    private Origem origem;

    @NotNull(message = "O sabor é obrigatório")
    @Enumerated(EnumType.STRING)
    private Sabor sabor;

    @NotNull(message = "O estilo é obrigatório")
    @ManyToOne
    @JoinColumn(name = "codigo_estilo")
    private Estilo estilo;

    @PrePersist
    @PreUpdate
    private void prePersistUpdate() {
        this.sku = sku.toUpperCase();
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cerveja cerveja = (Cerveja) o;

        return Objects.equals(codigo, cerveja.codigo);
    }

    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}
