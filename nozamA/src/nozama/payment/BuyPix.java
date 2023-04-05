package nozama.payment;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import nozama.Profile;
import nozama.products.Product;


public class BuyPix extends Buy{
    
    private LocalDateTime vencimento;
    JTextArea txt;
    JDialog j;
    JButton comprar, cancelar;
    JPanel panel;
    public BuyPix(Profile buyer, Profile seller, Product product){
        super(buyer, seller, product);
        j = new JDialog();
        comprar = new JButton("Comprar");
        cancelar =  new JButton("Cancelar");
        cancelar.addActionListener(e -> {
            j.dispose();
        });
        comprar.addActionListener(e -> {
            Pay();
            j.dispose();
        });
        panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        panel.add(comprar);
        panel.add(cancelar);
        j.setLayout(new BorderLayout());
        j.setModal(true);
        txt = new JTextArea(this.imprimirPix());
        j.add(txt,BorderLayout.CENTER);
        
        j.add(panel,BorderLayout.SOUTH);
        j.setTitle("Pix");
        j.pack();
        j.setVisible(true);
    }

    public String imprimirPix(){
        LocalDateTime now = LocalDateTime.now();
        this.vencimento = now.plusDays(7);
        this.vencimento = this.vencimento.plusDays(3);
        return "\nDia de hoje:"+now.getDayOfMonth()+"/"+now.getMonthValue()+"/"
        +now.getYear()+"\n"+"Data de Vencimento do pix:"+(vencimento.getDayOfMonth())+"/"+vencimento.getMonthValue()+"/"+vencimento.getYear()+
        "\nNome do comprador: "+ buyer.getUser()+"\nNome do vendedor: "+ seller.getUser()+"\nValor:"+product.getPrice()+"\n"+"Chave Pix:"+seller.getEmail();
    }
    
    


    @Override
    public String getVencimento() {
        return "Data de Vencimento: "+this.vencimento.getDayOfMonth()+"/"+this.vencimento.getMonthValue()+"/"+this.vencimento.getYear();
    }




   

   } 
