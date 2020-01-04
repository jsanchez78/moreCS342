public class InClassDecorator {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Coffee order = new Sugar( new Cream( new ExtraShot( new BasicCoffee())));

        double cost = order.makeCoffee();

        System.out.println("Total cost: $" + cost);
    }

}


interface Coffee{
    public double makeCoffee();
}

class BasicCoffee implements Coffee{

    private double cost = 3.50;
    @Override
    public double makeCoffee() {
        // TODO Auto-generated method stub

        System.out.println("Black Coffee: $3.50");
        return cost;
    }

}

abstract class CoffeeDecorator implements Coffee{

    protected Coffee specialCoffee;

    public CoffeeDecorator(Coffee specialCoffee) {
        this.specialCoffee = specialCoffee;
    }

}

class ExtraShot extends CoffeeDecorator{

    private double cost = 1.50;

    public ExtraShot(Coffee specialCoffee) {
        super(specialCoffee);
    }

    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addShot();
    }

    private double addShot() {
        System.out.println(" + extra Shot: $1.50");
        return cost;
    }
}

class Cream extends CoffeeDecorator{

    private double cost = .50;

    public Cream(Coffee specialCoffee) {
        super(specialCoffee);
    }

    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addCream();
    }

    private double addCream() {
        System.out.println(" + add cream: $.50");
        return cost;
    }
}

class Sugar extends CoffeeDecorator{

    private double cost = .50;

    public Sugar(Coffee specialCoffee) {
        super(specialCoffee);
    }

    public double makeCoffee() {
        return specialCoffee.makeCoffee() + addSugar();
    }

    private double addSugar() {
        System.out.println(" + add Sugar: $.50");
        return cost;
    }
}

