package com.mycompany.projmercearia;

public class AcessoController {
    private String usuarioLogado;
    private String horarioEntrada;
    private String horarioSaida;

    public boolean efetuarLogin(String login, String senha) {
        this.usuarioLogado = login;
        this.horarioEntrada = java.time.LocalDateTime.now().toString(); 
        return true;
    }
    public void efetuarLogout() {
        this.horarioSaida = java.time.LocalDateTime.now().toString(); 
        System.out.println("Usuário " + usuarioLogado + " entrou às " + horarioEntrada + " e saiu às " + horarioSaida);
        
       
        this.usuarioLogado = null;
    }
} 