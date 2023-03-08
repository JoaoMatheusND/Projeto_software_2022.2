package nozama.payment;

import nozama.Profile;
import nozama.products.Product;

public class BuyBoleto  extends Buy{

    public BuyBoleto(Profile buyer, Profile seller, Product product){
        super(buyer, seller, product);
    }

    @Override
    public void setVencimento(int v) {
       
    }

    @Override
    public void setValorMinimo(float v) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setProductState(String c) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getVencimento() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float getValorMinimo() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getProductState() {
        // TODO Auto-generated method stub
        return null;
    }
    
}