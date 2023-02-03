package br.com.franca.ShirtVirtual.model;

import br.com.franca.ShirtVirtual.enums.StatusContaReceber;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "conta_receber")
@SequenceGenerator(name = "seq_conta_receber", sequenceName = "seq_conta_receber", allocationSize = 1, initialValue = 1)
public class ContaReceber implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conta_receber")
    private Long id;

    @ManyToOne(targetEntity = Pessoa.class)
    @JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
    private Pessoa pessoa;

    @Column(name = "descricao_conta_receber")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusContaReceber statusContaReceber;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_vencimento_conta_receber")
    private Date dtVencimento;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_pagamento_conta_receber")
    private Date dtPagamento;

    @Column(name = "valor_total_conta_receber")
    private BigDecimal valorTotal;

    @Column(name = "valor_desconto_conta_receber")
    private BigDecimal valorDesconto = BigDecimal.valueOf(0.00);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusContaReceber getStatusContaReceber() {
        return statusContaReceber;
    }

    public void setStatusContaReceber(StatusContaReceber statusContaReceber) {
        this.statusContaReceber = statusContaReceber;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContaReceber)) return false;
        ContaReceber that = (ContaReceber) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}