package nozama.products.states;

//Estado para produto finalizado(compra, envio e recebimento)
public class FinishedState implements State{
    @Override
    public void actionState(){
        String str = "Parabéns por ter comprado o comproduto, não esqueça de avaliar-nos!!!";
    }
}