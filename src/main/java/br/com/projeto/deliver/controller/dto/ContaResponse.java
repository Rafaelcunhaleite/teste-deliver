package br.com.projeto.deliver.controller.dto;


import br.com.projeto.deliver.model.Conta;

import java.math.BigDecimal;
import java.util.Date;


public class ContaResponse {

    private Long idConta;
    private String nomeConta;
    private BigDecimal valorOriginal;
    private BigDecimal valorCorrigido;
    private String dataVencimento;
    private String dataPagamento;
    private Long diasAtraso;

    public static ContaResponse converter(Conta c){

        var contas = new ContaResponse();

        contas.setId(c.getIdConta());
        contas.setNomeConta(c.getNomeConta());
        contas.setValorOriginal(c.getValorOriginal());
        contas.setValorCorrigido(c.getValorCorrigido());
        contas.setDataVencimento(c.getDataVencimento());
        contas.setDataPagamento(c.getDataPagamento());
        contas.setDiasAtraso(c.getDiasAtraso());

        return contas;


    }

    public Long getIdConta() {
        return idConta;
    }

    public void setId(Long idConta) {
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
