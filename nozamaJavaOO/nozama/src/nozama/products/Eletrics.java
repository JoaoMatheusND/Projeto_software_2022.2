package nozama.products;

import nozama.Profile;

public class Eletrics extends Product{

    public Eletrics(Profile e){
        super(e);
    }

    private String category = "Eletrônicos";

    @Override
    public String getCategory() {
        return this.category;
    }
    
}
