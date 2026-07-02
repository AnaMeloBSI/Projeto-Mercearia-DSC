package com.mycompany.projmercearia;

import java.util.ArrayList;

public class FluxoVenda {
    
    private int id;
    private String dataHora;
    private String formaPagamento;
    private double valorTotal;
    private boolean pagamentoAprovado;
    
    
    private ArrayList<ItemVenda> itens = new ArrayList<>();
    
    
    public FluxoVenda(int id, String dataHora) {
        this.id = id;
        this.dataHora = dataHora;
    }
    
   
    public void adicionarItem(ItemVenda item) {
        this.itens.add(item);
    }
    
   
    public String selecionarFormaDePagamento(String forma) {
        this.formaPagamento = forma;
        return forma;
    }
    
    public boolean validarTransacaoFinanceira() {
        this.pagamentoAprovado = true;
        return true;
    }
    
    public double calcularTotalDaVenda() {
        double total = 0;
        for (ItemVenda i : itens) {
            total += i.calcularSubtotal();
        }
        this.valorTotal = total;
        return total;
    }
    
    public String emitirComprovanteDeVenda() {
        return "Total da Venda: R$ " + valorTotal;
    }
    
    
    public ArrayList<ItemVenda> getItens() {
        return itens;
    }
}