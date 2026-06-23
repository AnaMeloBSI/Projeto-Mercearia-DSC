public class Administrador extends Usuario {


    public Administrador(int id, String login, String senhaCrip){

        super(id, login, senhaCrip);

    }


    public PainelControle acessarPainelControle(){

        return new PainelControle();

    }

}


