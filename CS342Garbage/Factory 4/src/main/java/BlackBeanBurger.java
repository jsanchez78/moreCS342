public class BlackBeanBurger implements Burger{
    private double cost = 6.50;

    BlackBeanBurger(){

    }

    public double makeBurger(){
        System.out.println("BlackBean Burger: $6.50");
        return this.cost;
    }
}
