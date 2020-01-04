class Bacon extends BurgerDecorator{

    private double cost = 2.00;
    //Constructor
    public Bacon(Burger order1){
        super(order1);///Grabbing object from BurgerDecorator class
    }
    //Method implemented from Burger Interface
    public double makeBurger(){
        return this.specialBurger.makeBurger() + this.addBacon();
    }
    ///Getter for Bacon
    private double addBacon(){
        System.out.println(" + add Bacon: $2.00");
        return this.cost;
    }
}
