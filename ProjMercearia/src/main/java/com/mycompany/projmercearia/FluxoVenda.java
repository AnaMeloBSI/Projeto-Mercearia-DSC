package com.mycompany.projmercearia;

import java.util.ArrayList;

public class FluxoVenda {

    private int id;
    private String dataHora;
    private String formaPagamento;
    private double valorTotal;
    private boolean pagamentoAprovado;
    private String operadorResponsavel; 

    ArrayList<ItemVenda> itens = new ArrayList<>();

  
    public FluxoVenda(int id, String dataHora, String operadorResponsavel) {
        this.id = id;
        this.dataHora = dataHora;
        this.operadorResponsavel = operadorResponsavel;
    }
    
  
    public FluxoVenda(int id, String dataHora) {
        this.id = id;
        this.dataHora = dataHora;
        this.operadorResponsavel = "Operador Padrão";
    }

   
    public void adicionarItem(ItemVenda item) {
        itens.add(item);
    }

    public double calcularTotalDaVenda() {
        double total = 0;
        for (ItemVenda i : itens) {
            total += i.calcularSubtotal();
        }
        this.valorTotal = total;
        return total;
    }

    public String selecionarFormaDePagamento(String forma) {
        this.formaPagamento = forma;
        return forma;
    }

    public boolean validarTransacaoFinanceira() {
        pagamentoAprovado = true;
        return true;
    }

    public String emitirComprovanteDeVenda() {
        return "Venda realizada por: " + operadorResponsavel + "\nTotal: R$ " + calcularTotalDaVenda();
    }

   
    public ArrayList<ItemVenda> getItens() { return itens; }
    public String getFormaPagamento() { return formaPagamento; }
    public double getValorTotal() { return valorTotal; }
    public String getOperadorResponsavel() { return operadorResponsavel; }
}