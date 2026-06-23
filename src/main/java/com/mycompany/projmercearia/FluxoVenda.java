import java.util.ArrayList;


public class FluxoVenda {


private int id;
private String dataHora;
private String formaPagamento;
private double valorTotal;
private boolean pagamentoAprovado;


ArrayList<ItemVenda> itens = new ArrayList<>();


public FluxoVenda(int id,String dataHora){

    this.id=id;
    this.dataHora=dataHora;

}


public void adicionarItem(ItemVenda item){

    itens.add(item);

}


public double calcularTotalDaVenda(){

    double total=0;

    for(ItemVenda i: itens){

        total += i.calcularSubtotal();
    }


    return total;
}


public String selecionarFormaDePagamento(String forma){

    this.formaPagamento=forma;

    return forma;
}


public boolean validarTransacaoFinanceira(){

    pagamentoAprovado=true;

    return true;
}


public String emitirComprovanteDeVenda(){

return "Venda realizada\nTotal: R$ "+calcularTotalDaVenda();

}


}
