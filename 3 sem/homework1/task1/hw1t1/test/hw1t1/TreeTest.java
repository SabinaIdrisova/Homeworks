
package hw1t1;

import java.util.Iterator;
import org.junit.*;
import static org.junit.Assert.*;

public class TreeTest {
    
    public TreeTest() {
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
     * Test of isEmpty method, of class Tree.
     */
    @Test
    public void testIsEmpty() {
        Tree<Integer> tree = new Tree<>();
        assertTrue(tree.isEmpty());
        tree.addElement(2);
        assertFalse(tree.isEmpty());
    }

    /**
     * Test of addElement method, of class Tree.
     */
    @Test
    public void testAddElement() {
        Tree<Integer> tree = new Tree<>();
        assertFalse(tree.findElement(1));
        tree.addElement(1);
        assertTrue(tree.findElement(1));
    }

    /**
     * Test of findElement method, of class Tree.
     */
    @Test
    public void testFindElement() {
        Tree<Integer> tree = new Tree<>();
        tree.addElement(1);
        assertTrue(tree.findElement(1));
        assertFalse(tree.findElement(15));
    }

}
