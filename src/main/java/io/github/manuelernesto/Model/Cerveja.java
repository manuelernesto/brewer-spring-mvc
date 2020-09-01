package io.github.manuelernesto.Model;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "cerveja")
public class Cerveja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank(message = "Campo SKU é Obrigatório.")
    private String sku;

    @NotBlank(message = "Campo nome é Obrigatório.")
    private String nome;

    @NotBlank(message = "Campo descrição é Obrigatório.")
    @Size(message = "O tamanho da descrição deve estar entre 5 e 50.", min = 5, max = 50)
    private String descricao;

    private BigDecimal valor;
    @Column(name = "teor_alcoolico")
    private BigDecimal teorAlcoolico;

    private BigDecimal comissao;

    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    @Enumerated(EnumType.STRING)
    private Origem origem;

    @Enumerated(EnumType.STRING)
    private Sabor sabor;

    @ManyToOne
    @JoinColumn(name = "codigo_estilo")
    private Estilo estilo;

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
