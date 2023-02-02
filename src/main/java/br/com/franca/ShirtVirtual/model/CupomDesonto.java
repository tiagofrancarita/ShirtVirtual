package br.com.franca.ShirtVirtual.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "cup_desc")
@SequenceGenerator(name = "seq_cup_desc", sequenceName = "seq_cup_desc", allocationSize = 1, initialValue = 1)
public class CupomDesonto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cup_desc")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "codigo_desconto", nullable = false)
    private String codDesc;

    @Column(name = "valor_real_desconto", nullable = false)
    private BigDecimal valorRealDesc;

    @Column(name = "valor_percentual_desconto", nullable = false)
    private BigDecimal valorPercentDesc;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_validade_cupom", nullable = false)
    private Date dtValidadeCupom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
