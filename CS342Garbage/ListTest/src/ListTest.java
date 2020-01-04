import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    GenericStack<Integer> s;

    @BeforeEach
    void init(){
        s = new GenericStack<Integer>(200);
    }
    @Test
    void testInitGS(){
        assertEquals("GenericStack",s.getClass().getName(),"did not initialize proper object");
    }
    @Test
    void testInitNode(){
        assertequals("GenericList$Node",s.head.getClass().getName(),"did not initialize proper object");
    }
}
///$ to access inner class