import static org.junit.jupiter.api.Assertions.*;

import com.sun.tools.javah.Gen;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.AfterAll;



///Test string

class QueueTest {

    GenericQueue<Integer> q_int;
    GenericQueue<String> q_string;

    @BeforeEach
    void init_Q(){

         q_int = new GenericQueue<>(200);
         q_string = new GenericQueue<>("a");

    }
    @Test
    void checkLarge_Q(){
        q_int.dequeue();
        for (int i=0;i<100;i++){
            q_int.enqueue(i);
        }
        assertEquals(100,q_int.getLength());
    }

    //Stack Test
    @Test
    void testInit_Queue(){
        assertEquals("GenericQueue",q_string.head.getClass().getName(),"did not initialize proper object");
    }
    @Test
    void testInitNode(){
        assertEquals("GenericList$Node",q_string.head.getClass().getName(),"did not initialize proper object");
    }
    @Test
    void testForNodeValS(){
        assertEquals(200,q_int.head.data,"value not in node");
    }
    @Test
    void testPopNUllListVal(){
        assertNotEquals(200,q_int.dequeue(),"value not returned");
    }


    @Test
    void testEmptyList_S(){
        q_string.dequeue();
        assertNull(q_string.head);
    }

    @AfterEach
    void checkLength(){
        while(q_string.head!=null){
            q_string.dequeue();
        }
        assertEquals(0,q_string.getLength());
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