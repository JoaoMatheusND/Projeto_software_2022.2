package nozama.products.states;

import javax.swing.JOptionPane;

//Produto esgotado
public class SoldOutState implements State{
    @Override
    public void actionState(){
        String str =  "Produto Esgotado... Aguardando reposição!";
    } 
}