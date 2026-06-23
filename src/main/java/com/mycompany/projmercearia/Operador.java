public class Operador extends Usuario {


    public Operador(int id, String login, String senhaCrip){

        super(id, login, senhaCrip);

    }


    public FluxoVenda iniciarFluxoVenda(){

        return new FluxoVenda(
            1,
            "13/06/2026"
        );

    }

}
