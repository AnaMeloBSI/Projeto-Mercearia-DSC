public class Usuario {

    protected int id;
    protected String login;
    protected String senhaCriptografada;

    public Usuario(int id, String login, String senhaCrip){
        this.id = id;
        this.login = login;
        this.senhaCriptografada = senhaCrip;
    }


    public boolean efetuarLogin(String senha){

        return senhaCriptografada.equals(senha);
    }

}
