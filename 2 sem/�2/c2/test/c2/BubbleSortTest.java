package c2;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class BubbleSortTest {
    
    public BubbleSortTest() {
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
     * Test of bubbleSort method, of class BubbleSort.
     */
    @Test
    public void testBubbleSort() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        list1.add(15);
        list1.add(7);
        list1.add(13);
        Comparator<Integer> comparator = new Comparator<Integer>();
        BubbleSort<Integer> sort = new BubbleSort<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);
        list2.add(7);
        list2.add(13);
        list2.add(15);
        assertEquals(sort.bubbleSort(list1, comparator), list2);
    }
}
