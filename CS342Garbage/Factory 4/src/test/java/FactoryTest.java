import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;




class FactoryTest {

	private Burger new_burger;
	private Burger avocado_burger;
	private Burger blackBean;
	private Burger order;
	private Burger order2;
	private Burger order3;

	///Created an instance of the object before each test
	@BeforeEach
	void init(){
		new_burger = new BasicBurger();
		avocado_burger = new Avocado(new BasicBurger());
		blackBean = new BlackBeanBurger();
		order = new Avocado(BurgerFactory.getBurger("blb"));//BurgerFactory BlackBean
		order2 = BurgerFactory.getBurger("sb");
		order3 = BurgerFactory.getBurger("by");
	}

	@Test
	void testInitBasicBurger(){
		assertEquals("BasicBurger",new_burger.getClass().getName(),"did not initialize properly");
	}
	@Test
	void testBasicBurger_Cost(){
		assertEquals(6.50,new_burger.makeBurger(),"Basic Burger cost error");
	}
	@Test
	void testInitAvocado(){
		assertEquals("Avocado",avocado_burger.getClass().getName(),"did not initialize Avocado properly");
	}
	@Test
	void testAvocado_Cost(){
		assertEquals(8.50,avocado_burger.makeBurger(),"Avocado Burger Cost error");
	}
	@Test
	void testInitBlackBeanBurger(){
		assertEquals("BlackBeanBurger",blackBean.getClass().getName(),"did not initialize properly");
	}
	@Test
	void testBlackBean_Cost(){
		assertEquals(6.50,blackBean.makeBurger(),"Black Bean Burger Cost error");
	}
	///TEST Burger Factory
	//This will check an non empty object is returned

	@Test
	void testBurgerFactory_BLB(){
		assertNotNull(order);
	}

	@Test
	void testInitSalmonBurger(){
		assertEquals("SalmonBurger",order2.getClass().getName(),"did not initialize properly");
	}
	@Test
	void testInitBeyondBurger(){
		assertEquals("BeyondBurger",order3.getClass().getName(),"did not initialize properly");
	}
	///Test BurgerFactory creates instance of object rather than initializing a null object
	@Test
	void testBurgerFactory_Salmon(){
		assertNotNull(order2);
	}
	@Test
	void testBurgerFactory_Beyond(){
		assertNotNull(order3);
	}


}