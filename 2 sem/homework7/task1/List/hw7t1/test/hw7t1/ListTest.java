package hw7t1;

import hw7t1.List.ListElement;
import org.junit.*;
import static org.junit.Assert.*;

public class ListTest {
    
    public ListTest() {
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
     * Test of addToStart method, of class List.
     */
    @Test
    public void testAddToStart() {
        List<Integer> list = new List<Integer>();
        list.addToStart(1);
        assertTrue(list.exist(1));
    }

    /**
     * Test of addToEnd method, of class List.
     */
    @Test
    public void testAddToEnd() {
        List<Integer> list = new List<Integer>();
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        for (Integer i : list)
            assertTrue(list.exist(i));
    }

    /**
     * Test of insert method, of class List.
     */
    @Test
    public void testInsert() {
        List<Integer> list = new List<Integer>();
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        for (Integer i : list)
            assertTrue(list.exist(i));
    }

    /**
     * Test of deleteElement method, of class List.
     */
    @Test
    public void testDeleteElement() {
        List<Integer> list = new List<Integer>();
        list.addToStart(1);
        list.addToEnd(2);
        list.deleteElement(list.firstPosition());
        list.deleteElement(list.firstPosition());
        for (Integer i : list)
            assertFalse(list.exist(i));  
    }

    /**
     * Test of lengthOfList method, of class List.
     */
    @Test
    public void testLengthOfList() {
        List<String> list = new List<String>();
        list.addToStart("1");
        list.addToStart("2");
        Assert.assertEquals(2, list.lengthOfList());
    }

    /**
     * Test of getValue method, of class List.
     */
    @Test
    public void testGetValue() {
        List<String> list = new List<String>();
        list.addToStart("1");
        list.addToEnd("2");
        assertEquals("1", list.getValue(list.firstPosition()));
        assertEquals("2", list.getValue(list.lastPosition()));
    }

    /**
     * Test of exist method, of class List.
     */
    @Test
    public void testExist() {
        List<Integer> list = new List<Integer>();
        list.addToStart(1);
        assertTrue(list.exist(1));
        assertFalse(list.exist(2));
    }
}
