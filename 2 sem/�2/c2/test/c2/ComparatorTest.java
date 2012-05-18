package c2;

import org.junit.*;
import static org.junit.Assert.*;

public class ComparatorTest {
    
    public ComparatorTest() {
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
     * Test of compare method, of class Comparator.
     */
    @Test
    public void testCompare() {
        Comparator<Integer> comparator1 = new Comparator<Integer>();
        assertTrue(comparator1.compare(1, 8) < 0);
        assertTrue(comparator1.compare(5, 2) > 0);
        assertTrue(comparator1.compare(7, 7) == 0);
        Comparator<String> comparator2 = new Comparator<String>();
        assertTrue(comparator2.compare("aa", "ab") < 0);
        assertTrue(comparator2.compare("asdfg", "b") > 0);
        assertTrue(comparator2.compare("7", "7") == 0);   
    }
}
