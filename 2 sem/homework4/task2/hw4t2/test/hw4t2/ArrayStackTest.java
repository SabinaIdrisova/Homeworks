package hw4t2;

import org.junit.*;
import static org.junit.Assert.*;

public class ArrayStackTest {
    
    public ArrayStackTest() {
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
     * Test of push method, of class ArrayStack.
     */
    @Test
    public void testPush() {
        StackInterface stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(2, stack.top());
    }

    /**
     * Test of pop method, of class ArrayStack.
     */
    @Test
    public void testPop() {
        StackInterface stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.pop();
        Assert.assertEquals(2, stack.top());
    }

    /**
     * Test of isEmpty method, of class ArrayStack.
     */
    @Test
    public void testIsEmpty() {
        StackInterface stack = new ArrayStack();
        stack.push(1000);
        assertFalse(stack.isEmpty());
    }

    /**
     * Test of top method, of class ArrayStack.
     */
    @Test
    public void testTop() {
        StackInterface stack = new ArrayStack();
        stack.push(0);
        stack.push(80);
        Assert.assertEquals(80, stack.top());
    }
}
