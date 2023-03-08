package nozama.payment;

import nozama.Profile;
import nozama.products.Product;

public class BuyPix extends Buy{
    
    private int vencimento;
    private float valorMinimo;
    private String productState;
    
    public BuyPix(Profile buyer, Profile seller, Product product){
        super(buyer, seller, product);
    }

    @Override
    public void setVencimento(int v) {
       this.vencimento = v;
    }

    @Override
    public void setValorMinimo(float v) {
        this.valorMinimo = v;
    }

    @Override
    public void setProductState(String c) {
       this.productState = c;

    }

    @Override
    public int getVencimento() {
        return this.vencimento;
    }

    @Override
    public float getValorMinimo() {
        return this.valorMinimo;
    }

    @Override
    public String getProductState() {
        return this.productState;
    }
    public void gerarQrCode(){
//nome do comprador como chave

    }
    
}