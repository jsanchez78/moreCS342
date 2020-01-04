import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.AfterAll;



///Test string

class ListTest {

	GenericStack<Integer> s;

	@BeforeEach
	void init(){

		s = new GenericStack<>(200);

	}
	@Test
	void checkLarge(){
		s.pop();
		for (int i=0;i<100000;i++){
			s.push(i);
		}
		assertEquals(100000,s.getLength());
	}

	//Stack Test
	@Test
	void testInitGS(){
		assertEquals("GenericStack",s.getClass().getName(),"did not initialize proper object");
	}
	@Test
	void testInitNode(){
		assertEquals("GenericList$Node",s.head.getClass().getName(),"did not initialize proper object");
	}
	@Test
	void testForNodeValS(){
		assertEquals(200,s.head.data,"value not in node");
	}
	@Test
	void testPopNUllListVal(){
		assertEquals(200,s.pop(),"value not returned");
	}


	@Test
	void testEmptyList_S(){
		s.pop();
		assertNull(s.head);
	}

	@AfterEach
	void checkLength(){

		assertEquals(0,s.getLength());
	}

/**
	@Test
	void testAdd_S(){
		int i;
		for(i=10;i>0;i--){
			s.push(i);
		}

	}
***/



	/**
	 *
	 * Test iterator file
	 *
	 * */

}
///$ to access inner class
//getName() converts class name to a string