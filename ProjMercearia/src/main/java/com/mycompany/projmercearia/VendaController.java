package com.mycompany.projmercearia;

import java.util.ArrayList;

public class VendaController {

    private FluxoVenda vendaAtual;
    private ArrayList<FluxoVenda> historicoVendas = new ArrayList<>();

    public void iniciarNovaVenda(int id, String dataHora) {
        this.vendaAtual = new FluxoVenda(id, dataHora);
    }

    public void adicionarItemAVenda(ItemVenda item) {
        if (vendaAtual != null) {
            vendaAtual.adicionarItem(item);
        }
    }

    public void finalizarVenda() {
        if (vendaAtual != null) {
            vendaAtual.validarTransacaoFinanceira();
            vendaAtual.calcularTotalDaVenda();
            historicoVendas.add(vendaAtual);
        }
    }

    public FluxoVenda getVendaAtual() {
        return vendaAtual;
    }
}