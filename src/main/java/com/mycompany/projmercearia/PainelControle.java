import java.util.ArrayList;


public class PainelControle {


    ArrayList<Mercadoria> produtos =
        new ArrayList<>();


    public PainelControle(){

    }



    public boolean selecionarOpcaoMenu(String opcao){

        return true;

    }



    public Mercadoria buscarMercadoriaPorCodigo(String codigo){

        for(Mercadoria m : produtos){

            if(m.getCodigo().equals(codigo)){

                return m;
            }
        }

        return null;

    }



    public boolean salvarOuAtualizarMercadoria(Mercadoria m){

        produtos.add(m);

        return true;

    }



    public boolean excluirMercadoria(int id){

        return true;

    }



    public String visualizarRelatorioEstoque(){

        return "Produtos: " + produtos.size();

    }



    public String visualizarRelatorioFinanceiro(){

        return "Relatorio financeiro";

    }


}

