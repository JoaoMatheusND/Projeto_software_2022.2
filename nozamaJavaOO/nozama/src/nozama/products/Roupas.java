package nozama.products;

import nozama.Profile;

public class Roupas  extends Product{

    public Roupas(Profile e){
        super(e);
    }

    private String category = "Roupas";

    @Override
    public String getCategory() {
        return this.category;
    }
    
}
