package hw7t2;

import org.junit.*;
import static org.junit.Assert.*;

public class SetTest {
    
    public SetTest() {
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
     * Test of addElement method, of class Set.
     */
    @Test
    public void testAddElement(){
        Set<String> set = new Set<String>();
        set.addElement("m");
        set.addElement("h");
        set.addElement("m");
        assertTrue(set.elementExists("m"));
        assertFalse(set.elementExists("n"));
    }

    /**
     * Test of deleteElement method, of class Set.
     */
    @Test(expected=ElementNotFoundException.class)
    public void testDeleteElement() throws Exception {
        Set<Integer> set = new Set<Integer>();
        set.deleteElement(3);
        set.addElement(1);
        set.addElement(4);
        set.deleteElement(1);
        assertFalse(set.elementExists(1));
    }

    /**
     * Test of elementExists method, of class Set.
     */
    @Test
    public void testElementExists() {
        Set<Integer> set = new Set<Integer>();
        assertFalse(set.elementExists(1));
        set.addElement(1);
        assertTrue(set.elementExists(1));
    }

    /**
     * Test of intersection method, of class Set.
     */
    @Test
    public void testIntersection() {
        Set<Integer> set1 = new Set<Integer>();
        Set<Integer> set2 = new Set<Integer>();
        set1.addElement(1);
        set1.addElement(2);
        set2.addElement(2);
        set2.addElement(3);
        assertTrue(set1.intersection(set2).elementExists(2));
        assertFalse(set1.intersection(set2).elementExists(3));
    }

    /**
     * Test of association method, of class Set.
     */
    @Test
    public void testAssociation(){
        Set<Integer> set1 = new Set<Integer>();
        Set<Integer> set2 = new Set<Integer>();
        set1.addElement(1);
        set1.addElement(2);
        set2.addElement(2);
        set2.addElement(3);
        assertTrue(set1.association(set2).elementExists(1));
        assertTrue(set1.association(set2).elementExists(2));
        assertTrue(set1.association(set2).elementExists(3));
    }

    /**
     * Test of isEmpty method, of class Set.
     */
    @Test
    public void testIsEmpty() {
        Set<Integer> set = new Set<Integer>();
        assertTrue(set.isEmpty());
        set.addElement(0);
        assertFalse(set.isEmpty());
    }

    /**
     * Test of print method, of class Set.
     */
    @Test(expected=EmptySetException.class)
    public void testPrint() throws Exception {
        Set<String> set = new Set<String>();
        set.print();
    }
}
