import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

class ListTest {

	GenericStack<Integer> s;
	GenericQueue<Integer> q;
	@BeforeEach
	void init(){

		s = new GenericStack<>(200);

		q = new GenericQueue<>(300);
	}

	@Test
	void testInitGS(){
		assertEquals("GenericStack",s.getClass().getName(),"did not initialize proper object");
	}
	@Test
	void testInitGQ(){
		assertEquals("GenericQueue",q.getClass().getName(),"did not initialize proper object");
	}
	@Test
	void testInitNode(){
		assertEquals("GenericList$Node",s.getHead().getClass().getName(),"did not initialize proper object");
	}
	@Test
	void testForNodeVal(){
		assertEquals(200,s.getHead().data,"value not in node");
	}
	@Test
	void testPopNUllListVal(){
		assertEquals(200,s.pop(),"value not returned");
	}
	@Test
	void testEmptyList(){
		s.pop();
		assertNull(s.getHead());
	}
}
///$ to access inner class
//getName() converts class name to a string