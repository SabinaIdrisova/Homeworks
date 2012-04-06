package cont;

import org.junit.*;
import static org.junit.Assert.*;

public class QueueTest {
    
    public QueueTest() {
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
     * Test of enqueue method, of class Queue.
     */
    @Test
    public void testEnqueue() {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("abc", 2);
        queue.enqueue("def", 1);
        try {
            Assert.assertEquals("def", queue.dequeue());
        } catch (EmptyQueueException ex) {
            
        }
        
    }

    /**
     * Test of dequeue method, of class Queue.
     */
    @Test(expected=EmptyQueueException.class)
    public void testDequeue() throws EmptyQueueException {
         Queue<String> queue = new Queue<String>();
         queue.enqueue("a", 1);
         queue.enqueue("b", 100);
         Assert.assertEquals("a", queue.dequeue());
         queue.dequeue();
         queue.dequeue();
    }

    /**
     * Test of print method, of class Queue.
     */
    @Test(expected=EmptyQueueException.class)
    public void testPrint() throws EmptyQueueException {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("asdf", 5);
        queue.print();
        queue.dequeue();
        queue.print(); 
    }

    /**
     * Test of isEmpty method, of class Queue.
     */
    @Test
    public void testIsEmptyIfQueueIsEmpty() {
        Queue<String> queue = new Queue<String>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmptyIfQueueIsNotEmpty() {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("1234", 4);
        assertFalse(queue.isEmpty());
    }
    
}
