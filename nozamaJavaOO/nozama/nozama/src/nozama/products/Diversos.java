package nozama.products;

import nozama.Profile;

public class Diversos extends Product{

    public Diversos(Profile e){
        super(e);
    }

    private String category = "Diversos";
    
    @Override
    public String getCategory() {
        return this.category;
    }
    
}
