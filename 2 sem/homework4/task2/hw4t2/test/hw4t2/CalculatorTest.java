/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4t2;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 1
 */
public class CalculatorTest {
    
    public CalculatorTest() {
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
     * Test of makeOperation method, of class Calculator.
     */
    @Test
    public void testMakeOperation() {
        StackInterface stack = new ListStack();
        stack.push(1);
        Calculator calculator = new Calculator(stack);
        calculator.makeOperation(1, '+');
        assertEquals(2, stack.top());
    }

    /**
     * Test of addNumber method, of class Calculator.
     */
    @Test
    public void testAddNumber() {
        StackInterface stack = new ListStack();
        Calculator calculator = new Calculator(stack);
        calculator.addNumber('4');
        assertEquals(4, stack.top());
    }

    /**
     * Test of getResult method, of class Calculator.
     */
    @Test
    public void testGetResult() {
        StackInterface stack = new ListStack();
        Calculator calculator = new Calculator(stack);
        stack.push(1);
        stack.push(2);
        calculator.getResult('*');
        assertEquals(2, stack.top());
    }
}
