public class Avocado extends BurgerDecorator{
    private double cost = 2.00;
    //Constructor
    public Avocado(Burger order1){
        super(order1);///Attaining object from super class constructor
    }
    //Method obtained from interface Burger
    public double makeBurger(){
        return this.specialBurger.makeBurger() + this.addAvocado();
    }
    private double addAvocado(){
        System.out.println("+ add avocado: $2.00");
        return this.cost;
    }
}
