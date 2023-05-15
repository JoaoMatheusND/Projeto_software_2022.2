package nozama.products.states;

//Estado para produto em Criação 
public class NullProductState implements State{
    @Override
    public void actionState(){
        String str =  "Produto em estado de Criação. Por favor finalizar o produto ou excluir!";
    }
}