package br.com.franca.ShirtVirtual.model;


import javax.persistence.*;

@Entity
@Table(name = "acesso")
@SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso", allocationSize = 1, initialValue = 1)
public class Acesso {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
    private Long id;

    @Column(name = "descricao_acesso", nullable = false)
    private String descAcesso;

}
