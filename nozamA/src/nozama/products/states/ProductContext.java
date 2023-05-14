package nozama.products.states;


public class ProductContext{
    private State state;

    public void ProductContext(){
        this.state = new NullProductState(); //Estado inicial de todo produto criado no nozama;
    }

    public void setState(State newState){
        this.state = newState;
    }

    public void performerAction(){
        this.state.actionState();
    }

    public Boolean checkUnavailableState(){
        return (state instanceof NullProductState || state instanceof SoldOutState);
    }

}