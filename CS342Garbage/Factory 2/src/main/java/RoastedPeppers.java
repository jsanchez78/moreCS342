class RoastedPeppers extends BurgerDecorator{

    private double cost = 2.00;
    //Constructor
    public RoastedPeppers(Burger order1){
        super(order1);///Obtaining object from BurgerDecorator super class
    }
    ///Method implemented from Burger Interface
    public double makeBurger(){
        return this.specialBurger.makeBurger() + this.addRoastedPeppers();
    }
    //Getter of private data member
    private double addRoastedPeppers(){
        System.out.println("+ Roasted Peppers: $2.00");
        return this.cost;
    }
}
