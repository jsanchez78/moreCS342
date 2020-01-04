abstract class BurgerDecorator implements Burger{
    ////Why must BurgerDecorator implement Burger?

    //Ability to access any combination by using makeBurger(); ???
    protected Burger specialBurger;

    public BurgerDecorator(Burger order1){
        this.specialBurger = order1;
    }

}
