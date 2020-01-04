class GrilledOnions extends BurgerDecorator{
    private double cost = 2.00;

    public GrilledOnions(Burger order1){
        super(order1);
    }
    public double makeBurger(){
        return this.specialBurger.makeBurger() + this.addGrilledOnions();
    }
    private double addGrilledOnions(){
        System.out.println(" + add GrilledOnions: $2.00");
        return this.cost;
    }
}
