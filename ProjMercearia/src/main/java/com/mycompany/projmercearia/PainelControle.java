package com.mycompany.projmercearia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PainelControle {

    public void cadastrarMercadoria(Mercadoria mercadoria) {
        String sqlVerifica = "SELECT codigo_identificador FROM produto WHERE codigo_identificador = ?";
        
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmtVerifica = conn.prepareStatement(sqlVerifica)) {
            
            stmtVerifica.setInt(1, mercadoria.getCodigoIdentificador());
            try (ResultSet rs = stmtVerifica.executeQuery()) {
                if (rs.next()) {
                    String sqlUpdate = "UPDATE produto SET nome = ?, categoria = ?, preco_compra = ?, preco_venda = ?, quantidade_estoque = ?, fornecedor = ? WHERE codigo_identificador = ?";
                    try (PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate)) {
                        stmtUpdate.setString(1, mercadoria.getNome());
                        stmtUpdate.setString(2, mercadoria.getCategoria());
                        stmtUpdate.setDouble(3, mercadoria.getPrecoCompra());
                        stmtUpdate.setDouble(4, mercadoria.getPrecoVenda());
                        stmtUpdate.setInt(5, mercadoria.getQuantidadeEstoque());
                        stmtUpdate.setString(6, mercadoria.getFornecedor());
                        stmtUpdate.setInt(7, mercadoria.getCodigoIdentificador());
                        stmtUpdate.executeUpdate();
                    }
                } else {
                    String sqlInsert = "INSERT INTO produto (codigo_identificador, nome, categoria, preco_compra, preco_venda, quantidade_estoque, fornecedor) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
                        stmtInsert.setInt(1, mercadoria.getCodigoIdentificador());
                        stmtInsert.setString(2, mercadoria.getNome());
                        stmtInsert.setString(3, mercadoria.getCategoria());
                        stmtInsert.setDouble(4, mercadoria.getPrecoCompra());
                        stmtInsert.setDouble(5, mercadoria.getPrecoVenda());
                        stmtInsert.setInt(6, mercadoria.getQuantidadeEstoque());
                        stmtInsert.setString(7, mercadoria.getFornecedor());
                        stmtInsert.executeUpdate();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erro no PainelControle ao cadastrar: " + e.getMessage());
        }
    }

    public Mercadoria buscarMercadoriaPorCodigo(int codigo) {
        String sql = "SELECT * FROM produto WHERE codigo_identificador = ?";
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Mercadoria(
                        rs.getInt("codigo_identificador"),
                        rs.getString("nome"),
                        rs.getString("categoria"),
                        rs.getDouble("preco_compra"),
                        rs.getDouble("preco_venda"),
                        rs.getInt("quantidade_estoque"),
                        rs.getString("fornecedor")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Erro no PainelControle ao buscar: " + e.getMessage());
        }
        return null;
    }
    
    public void excluirMercadoria(int codigo) {
        String sql = "DELETE FROM produto WHERE codigo_identificador = ?";
        try (java.sql.Connection conn = ConexaoBanco.conectar();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            System.out.println("Mercadoria excluída do banco com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao excluir no PainelControle: " + e.getMessage());
        }
    }
    
    public java.util.ArrayList<Mercadoria> listarTodasMercadorias() {
        java.util.ArrayList<Mercadoria> lista = new java.util.ArrayList<>();
        String sql = "SELECT * FROM produto";

        try (java.sql.Connection conn = ConexaoBanco.conectar();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Mercadoria m = new Mercadoria(
                    rs.getInt("codigo_identificador"),
                    rs.getString("nome"),
                    rs.getString("categoria"),
                    rs.getDouble("preco_compra"),
                    rs.getDouble("preco_venda"),
                    rs.getInt("quantidade_estoque"),
                    rs.getString("fornecedor")
                );
                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar mercadorias: " + e.getMessage());
        }
        return lista;
    }
}

