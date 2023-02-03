package br.com.franca.ShirtVirtual.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cup_desc")
@SequenceGenerator(name = "seq_cup_desc", sequenceName = "seq_cup_desc", allocationSize = 1, initialValue = 1)
public class CupomDesonto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cup_desc")
    private Long id;

    @Column(name = "codigo_desconto")
    private String codDesc;

    @Column(name = "valor_real_desconto")
    private BigDecimal valorRealDesc;

    @Column(name = "valor_percentual_desconto")
    private BigDecimal valorPercentDesc;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_validade_cupom")
    private Date dtValidadeCupom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodDesc() {
        return codDesc;
    }

    public void setCodDesc(String codDesc) {
        this.codDesc = codDesc;
    }

    public BigDecimal getValorRealDesc() {
        return valorRealDesc;
    }

    public void setValorRealDesc(BigDecimal valorRealDesc) {
        this.valorRealDesc = valorRealDesc;
    }

    public BigDecimal getValorPercentDesc() {
        return valorPercentDesc;
    }

    public void setValorPercentDesc(BigDecimal valorPercentDesc) {
        this.valorPercentDesc = valorPercentDesc;
    }

    public Date getDtValidadeCupom() {
        return dtValidadeCupom;
    }

    public void setDtValidadeCupom(Date dtValidadeCupom) {
        this.dtValidadeCupom = dtValidadeCupom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CupomDesonto)) return false;
        CupomDesonto that = (CupomDesonto) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}