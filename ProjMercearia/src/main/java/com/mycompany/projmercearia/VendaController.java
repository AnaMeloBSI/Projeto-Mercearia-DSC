package com.mycompany.projmercearia;

import java.util.ArrayList;

public class VendaController {
    private FluxoVenda vendaAtual;
    private ArrayList<FluxoVenda> historicoVendas = new ArrayList<>();

    public void iniciarNovaVenda(int idVenda, Usuario operador) {
        String dataHoraAtual = java.time.LocalDateTime.now().toString();
        vendaAtual = new FluxoVenda(idVenda, dataHoraAtual, operador);
    }

    public void adicionarItemAVenda(Mercadoria produto, int qtd) {
        if (vendaAtual != null) {
            vendaAtual.addItemAVenda(produto, qtd);
        }
    }

    public String finalizarVenda(String formaPagamento, EstoqueController estoqueControl) {
        if (vendaAtual == null) return "Nenhuma venda ativa.";

        vendaAtual.selecionarFormaDePagamento(formaPagamento);
        vendaAtual.calcularTotalDaVenda();
        historicoVendas.add(vendaAtual);
        
            for (ItemVenda item : vendaAtual.getItens()) {
            Mercadoria p = item.getProduto();
            p.setQuantidadeEstoque(p.getQuantidadeEstoque() - item.getQuantidade());
        }

        String comprovante = vendaAtual.emitirComprovanteDeVenda();
        vendaAtual = null; 
        return comprovante;
    }

    public ArrayList<FluxoVenda> getHistoricoVendas() { return historicoVendas; }
}
