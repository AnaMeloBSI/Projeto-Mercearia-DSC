public class ItemVenda {

    private int quantidade;
    private double precoUnitario;


    public ItemVenda(int quantidade,double precoUnitario){

        this.quantidade=quantidade;
        this.precoUnitario=precoUnitario;
    }


    public double calcularSubtotal(){

        return quantidade * precoUnitario;
    }

}
