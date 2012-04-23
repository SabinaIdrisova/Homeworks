package hw7t1stack;

import org.junit.*;
import static org.junit.Assert.*;

public class StackTest {
    
    public StackTest() {
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
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        int top = 0;
        try {
            top = stack.top();
        } catch (EmptyStackException ex) {
        }
        Assert.assertEquals(1, top);
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test(expected=EmptyStackException.class)
    public void testPop() throws Exception {
        Stack<String> stack = new Stack<String>();
        stack.push("ok");
        stack.push("111");
        String result = stack.pop();
        Assert.assertEquals("111", result);
        stack.pop();
        stack.pop();
    }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        Stack<Integer> stack = new Stack<Integer>();
        assertTrue(stack.isEmpty());
    }

    /**
     * Test of top method, of class Stack.
     */
    @Test(expected=EmptyStackException.class)
    public void testTop() throws Exception {
        Stack<String> stack = new Stack<String>();
        String str = stack.top();
        stack.push("4");
        stack.push("1");
        Assert.assertEquals("1", stack.top());   
    }
}
