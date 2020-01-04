public class SalmonBurger implements Burger{

    private double cost = 6.50;
    //Factory Method Constructor
    //Ready to be implemented during run time
    SalmonBurger(){

    }
    //Method implemented from Burger interface
    public double makeBurger(){
        System.out.println("Salmon Burger: $6.50");
        return this.cost;
    }
}
