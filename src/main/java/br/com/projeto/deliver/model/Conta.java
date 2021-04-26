package br.com.projeto.deliver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "conta")
public class Conta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idConta")
    private Long idConta;

    @Column(name="nomeConta")
    private String nomeConta;

    @Column(name="valorOriginal")
    private BigDecimal valorOriginal;

    @Column(name="valorCorrigido")
    private BigDecimal valorCorrigido;

    @Column(name="dataVencimento")
    private String dataVencimento;

    @Column(name="dataPagamento")
    private String dataPagamento;

    @Column(name="diasAtraso")
    private Long diasAtraso;

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public BigDecimal getValorCorrigido() {
        return valorCorrigido;
    }

    public void setValorCorrigido(BigDecimal valorCorrigido) {
        this.valorCorrigido = valorCorrigido;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Long getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(Long diasAtraso) {
        this.diasAtraso = diasAtraso;
    }







}
