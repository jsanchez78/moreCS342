public class BeyondBurger implements Burger {
    private double cost = 6.50;

    ///Factory Method portion
    //Empty Constructor ready to be modified during run time based on calls to BurgerDecorator class
    BeyondBurger(){

    }
    ///Method implemented from Burger Interface
    public double makeBurger(){
        System.out.println("Beyond Burger: $6.50");
        return this.cost;
    }

}
