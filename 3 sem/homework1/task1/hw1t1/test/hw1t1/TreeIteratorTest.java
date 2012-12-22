
package hw1t1;

import org.junit.*;
import static org.junit.Assert.*;

public class TreeIteratorTest {
    
    public TreeIteratorTest() {
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
     * Test of hasNext method, of class TreeIterator.
     */
    @Test
    public void testHasNext() {
        Tree<Integer> tree = new Tree<>();
        tree.addElement(1);
        tree.addElement(2);
        TreeIterator<Integer> iterator = (TreeIterator<Integer>) tree.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());     
    }

    /**
     * Test of next method, of class TreeIterator.
     */
    @Test
    public void testNext() {
        Tree<Integer> tree = new Tree<>();
        tree.addElement(8);
        tree.addElement(9);
        tree.addElement(4);
        tree.addElement(3);
        tree.addElement(5);
        tree.addElement(2);
        Integer values[] = {8, 4, 3, 2, 5, 9};
        int i = 0;
        TreeIterator<Integer> iterator = (TreeIterator<Integer>) tree.iterator();
        while (iterator.hasNext()) {
            assertEquals(iterator.next(), values[i]);
            i++;
        }
    }

}
