/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw8;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lich
 */
public class MyPriorityQueueTest {

    public MyPriorityQueueTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of enqueue method, of class MyPriorityQueue.
     */
    @Test
    public void testEnqueueDequeueInteger() throws Exception {
        MyPriorityQueue<Integer> instance = new MyPriorityQueue<Integer>();
        instance.enqueue(50, 1);
        instance.enqueue(100, 0);
        int ret = instance.dequeue();
        assertEquals(100, ret);
        ret = instance.dequeue();
        assertEquals(50, ret);
    }

    @Test
    public void testEnqueueDequeueString() throws Exception {
        MyPriorityQueue<String> instance = new MyPriorityQueue<String>();
        instance.enqueue("str1", 1);
        instance.enqueue("str2", 1);
        String ret = instance.dequeue();
        assertEquals("str2", ret);
        ret = instance.dequeue();
        assertEquals("str1", ret);    
    }

    @Test(expected=EmptyQueueException.class)
    public void testQueueException() throws Exception {
        MyPriorityQueue<String> instance = new MyPriorityQueue<String>();
        instance.dequeue();
    }
}



