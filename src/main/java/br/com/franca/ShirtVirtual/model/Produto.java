package br.com.franca.ShirtVirtual.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "Produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long id;

    @Column(name = "tipo_unidade", nullable = false)
    private String tipoUnidade;

    @Column(name = "nome_produto", nullable = false)
    private String nome;

    @Column(name = "descricao_produto", columnDefinition = "text", length = 2000, nullable = false)
    private String descricaoProduto;

    /** Nota item nota produto - ASSOCIAR
        private NotaItemProduto notaItemProduto
    **/

    @Column(name = "peso_produto", nullable = false)
    private Double peso;

    @Column(name = "largura_produto", nullable = false)
    private Double largura;

    @Column(name = "altura_produto", nullable = false)
    private Double altura;

    @Column(name = "profundidade_produto", nullable = false)
    private Double profundidade;

    @Column(name = "valor_total_venda", nullable = false)
    private BigDecimal valorTotalVenda;

    @Column(name = "quantidade_estoque_produto", nullable = false)
    private Integer qtdEstoque;

    @Column(name = "quantidade_alerta_estoque_produto", nullable = false)
    private Integer qtdAlertaEstoque;

    @Column(name = "link_youtube_produto")
    private String linkYT;

    @Column(name = "alerta_quantidade_estoque", nullable = false)
    private Boolean alertaQtdEstoque = true;

    @Column(name = "quantidade_clique_produto")
    private Integer qtdClickProduto = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(Double profundidade) {
        this.profundidade = profundidade;
    }

    public BigDecimal getValorTotalVenda() {
        return valorTotalVenda;
    }

    public void setValorTotalVenda(BigDecimal valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Integer getQtdAlertaEstoque() {
        return qtdAlertaEstoque;
    }

    public void setQtdAlertaEstoque(Integer qtdAlertaEstoque) {
        this.qtdAlertaEstoque = qtdAlertaEstoque;
    }

    public String getLinkYT() {
        return linkYT;
    }

    public void setLinkYT(String linkYT) {
        this.linkYT = linkYT;
    }

    public Boolean getAlertaQtdEstoque() {
        return alertaQtdEstoque;
    }

    public void setAlertaQtdEstoque(Boolean alertaQtdEstoque) {
        this.alertaQtdEstoque = alertaQtdEstoque;
    }

    public Integer getQtdClickProduto() {
        return qtdClickProduto;
    }

    public void setQtdClickProduto(Integer qtdClickProduto) {
        this.qtdClickProduto = qtdClickProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}