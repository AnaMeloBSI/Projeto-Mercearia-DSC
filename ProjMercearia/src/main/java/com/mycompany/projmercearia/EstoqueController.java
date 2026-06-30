package com.mycompany.projmercearia;

import java.util.ArrayList;

public class EstoqueController {
    private ArrayList<Mercadoria> listaProdutos = new ArrayList<>();

    public boolean salvarOuAtualizarMercadoria(int codigo, String nome, String categoria, double precoCompra, double precoVenda, int quantidade, String fornecedor) {
        for (Mercadoria m : listaProdutos) {
            if (m.getCodigoIdentificador() == codigo) { 
                m.setNome(nome);
                m.setCategoria(categoria);
                m.setPrecoCompra(precoCompra);
                m.setPrecoVenda(precoVenda);
                m.setQuantidadeEstoque(quantidade);
                m.setFornecedor(fornecedor);
                return true;
            }
        }
        
        Mercadoria nova = new Mercadoria(codigo, nome, categoria, precoCompra, precoVenda, quantidade, fornecedor);
        listaProdutos.add(nova);
        return true;
    }

    public boolean excluirMercadoria(int codigo) { 
        return listaProdutos.removeIf(m -> m.getCodigoIdentificador() == codigo);
    }

    public ArrayList<Mercadoria> visualizarRelatorioEstoque() { 
        return listaProdutos;
    }
}


