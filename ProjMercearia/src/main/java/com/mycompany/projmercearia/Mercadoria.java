package com.mycompany.projmercearia;

public class Mercadoria {
    private int codigoIdentificador;
    private String nome;
    private String categoria;
    private double precoCompra;
    private double precoVenda;
    private int quantidadeEstoque;
    private String fornecedor;

    public Mercadoria(int codigoIdentificador, String nome, String categoria, double precoCompra, double precoVenda, int quantidadeEstoque, String fornecedor) {
        this.codigoIdentificador = codigoIdentificador;
        this.nome = nome;
        this.categoria = categoria;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidadeEstoque = quantidadeEstoque;
        this.fornecedor = fornecedor;
    }

    public int getCodigoIdentificador() { return codigoIdentificador; }
    public void setCodigoIdentificador(int codigo) { this.codigoIdentificador = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public double getPrecoCompra() { return precoCompra; }
    public void setPrecoCompra(double precoCompra) { this.precoCompra = precoCompra; }
    public double getPrecoVenda() { return precoVenda; }
    public void setPrecoVenda(double precoVenda) { this.precoVenda = precoVenda; }
    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(int qtd) { this.quantidadeEstoque = qtd; }
    public String getFornecedor() { return fornecedor; }
    public void setFornecedor(String fornecedor) { this.fornecedor = fornecedor; }
}
