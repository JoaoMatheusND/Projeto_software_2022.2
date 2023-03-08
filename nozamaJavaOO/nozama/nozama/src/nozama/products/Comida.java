package nozama.products;

import nozama.Profile;


public class Comida  extends Product{

    public Comida(Profile e){
        super(e);
    }

    private String category = "Comida";

    @Override
    public String getCategory() {
        return this.category;
    }
    
}
