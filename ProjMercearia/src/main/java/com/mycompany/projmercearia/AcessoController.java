package com.mycompany.projmercearia;

import java.util.ArrayList;

public class AcessoController {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Usuario usuarioLogado = null;
    private String horarioEntrada = "";
    private String horarioSaida = "";

    public boolean cadastrarUsuario(String nome, String login, String senha, String perfil) {
        // Maísa aplicará o algoritmo de Hash na senha aqui conforme o diagrama [cite: 166]
        Usuario novo = new Usuario(nome, login, senha, perfil);
        usuarios.add(novo);
        return true;
    }

    public boolean efetuarLogin(String login, String senha) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                usuarioLogado = u;
                this.horarioEntrada = java.time.LocalDateTime.now().toString(); // Registro de Entrada
                return true;
            }
        }
        return false;
    }

    public void efetuarLogout() {
        if (usuarioLogado != null) {
            this.horarioSaida = java.time.LocalDateTime.now().toString(); // Registro de Saída
            System.out.println("LOGOUT: " + usuarioLogado.getNome() + " saiu às " + horarioSaida);
            usuarioLogado = null;
        }
    }

    public Usuario getUsuarioLogado() { return usuarioLogado; }
}
