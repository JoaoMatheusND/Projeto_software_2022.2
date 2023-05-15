package nozama.products.states;

import javax.swing.JOptionPane;

//Estado para produto enviado(após pagamento)
public class SendingState implements State{
    @Override
    public void actionState(){
        String str = "Seu produto já foi enviado com sucesso e em breve chegará a sua casa.";
    }
}