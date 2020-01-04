
class BasicBurger implements Burger{

    private double cost = 6.50;

    ///Constructor ready to be altered by the subclasses created

    BasicBurger(){

    }

    //Method which will be extended by extended by all other add ons
    public double makeBurger(){
        System.out.println("Basic Burger: $6.50");
        return this.cost;
    }


}

