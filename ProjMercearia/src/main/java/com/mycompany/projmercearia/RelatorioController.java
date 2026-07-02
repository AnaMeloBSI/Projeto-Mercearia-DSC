package com.mycompany.projmercearia;

import java.util.ArrayList;

public class RelatorioController {

    public String gerarRelatorioFinanceiro(ArrayList<FluxoVenda> vendas, ArrayList<Mercadoria> produtos) {
        double totalFaturamento = 0;
        double totalCustos = 0;

        for (FluxoVenda v : vendas) {
            totalFaturamento += v.calcularTotalDaVenda();
        }

        for (Mercadoria m : produtos) {
            totalCustos += (m.getPrecoCompra() * m.getQuantidadeEstoque()); 
        }

        double lucroLiquido = totalFaturamento - totalCustos; 

        return "=== RELATÓRIO FINANCEIRO ===\n" +
               "Faturamento: R$ " + totalFaturamento + "\n" +
               "Custos: R$ " + totalCustos + "\n" +
               "Lucro: R$ " + lucroLiquido;
    }
}
