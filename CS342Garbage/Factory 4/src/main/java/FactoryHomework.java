
public class FactoryHomework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Factory Design Pattern HW!");
		///Creating an instance to test the value on the command line
		Burger order = new Avocado(new Bacon(new FriedEgg(new GrilledOnions(new RoastedPeppers(BurgerFactory.getBurger("blb"))))));
		double cost = order.makeBurger();
		System.out.println("Total cost: $" + cost);
	}

}

