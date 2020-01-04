import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.AfterAll;

import java.util.ArrayList;


import java.util.Iterator;




public class IteratorTest {

    GenericQueue<Integer> queue = new GenericQueue<>(0);
    GenericStack<String> stack = new GenericStack<>("a");
    ///GLIterator<Iterator> iterator_test;
    Iterator<String> it_stack = stack.createIterator();
    Iterator<Integer> it_queue = queue.createIterator();


    @Test
    void testInitIterator_Stack(){
        assertEquals("GLIterator",it_stack.getClass().getName(),"did not initialize proper object");
    }
    @Test
    void testInitIterator_Queue(){
        assertEquals("GLIterator",it_queue.getClass().getName(),"did not initialize proper object");
    }

    @Test
    void testNonEmptyIterator_Stack(){

        assertNotNull(it_stack);
    }
    @Test
    void testNonEmptyIterator_Queue(){
        assertNotNull(it_queue);
    }
    @Test
    void testEmpty_Stack(){
        stack.pop();
        assertTrue(it_stack.hasNext());
    }
    @Test
    void testEmpty_Queue(){
        queue.dequeue();
        assertTrue(it_stack.hasNext());
    }
    @Test
    void differentIterators(){

        assertNotEquals(it_stack,it_queue);
    }
    @Test
    void IteratorEndOfList_Stack(){
        for (int i=0;i<10;i++){
            stack.push("i");
        }
        while(it_stack.hasNext()){
            it_stack.next();
        }
        assertFalse(it_stack.hasNext());

    }

    @Test
    void IteratorBeginningOfList_Queue(){
        assertTrue(it_queue.hasNext());

    }
    @Test
    void IteratorBeginningOfList_Stack(){
        assertTrue(it_stack.hasNext());

    }

    @AfterEach
    void NextNotNull_Stack(){
        if(it_stack.hasNext())
            it_stack.next();
        assertNotNull(it_stack);
    }
    @AfterEach
    void NextNotNull_Queue(){
        if(it_queue.hasNext())
            it_queue.next();
        assertNotNull(it_queue);
    }



    ///Queue + Stack
}

