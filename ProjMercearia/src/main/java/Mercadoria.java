package com.mycompany.projmercearia;
public class Mercadoria {

    private int id;
    private String codigoIdentificador;
    private String nome;
    private String descricao;
    private String categoria;

    private double precoCompra;
    private double precoVenda;

    private int qtdEstoque;

    private String fornecedor;


    public Mercadoria(
            int id,
            String codigo,
            String nome,
            double precoVenda,
            int qtdEstoque){

        this.id=id;
        this.codigoIdentificador=codigo;
        this.nome=nome;
        this.precoVenda=precoVenda;
        this.qtdEstoque=qtdEstoque;
    }


    public boolean decrementarEstoque(int qtd){

        if(qtdEstoque >= qtd){

            qtdEstoque -= qtd;
            return true;
        }

        return false;
    }


    public String getCodigo(){
        return codigoIdentificador;
    }


    public double getPrecoVenda(){
        return precoVenda;
    }

}
