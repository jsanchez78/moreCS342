class FriedEgg extends BurgerDecorator{
    private double cost = 2.00;

    public FriedEgg(Burger order1){
        super(order1);
    }

    public double makeBurger(){
        return this.specialBurger.makeBurger() + this.addFriedEgg();
    }
    private double addFriedEgg(){
        System.out.println(" + add FriedEgg: $2.00");
        return this.cost;
    }
}
