package nozama.products;

import nozama.Profile;


public class Casa extends Product {

    public Casa(Profile e){
        super(e);
    }

    private String category = "Casa";

    @Override
    public String getCategory() {
        return this.category;
    }
    
}
