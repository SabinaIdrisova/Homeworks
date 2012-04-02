package hw5t2;

import org.junit.*;
import static org.junit.Assert.*;

public class UniqueListTest {
    
    public UniqueListTest() {
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
     * Test of addToStart method, of class UniqueList.
     */
    @Test(expected=ElementExistsInListException.class)
    public void testAddToStart() throws Exception {
        UniqueList list = new UniqueList();
        list.addToStart(2);
        list.addToStart(1);
        list.addToStart(1);
        Assert.assertEquals(1, list.getValue(list.firstPosition()));
    }

    /**
     * Test of addToEnd method, of class UniqueList.
     */
    @Test(expected=ElementExistsInListException.class)
    public void testAddToEnd() throws Exception {
        UniqueList list = new UniqueList();
        list.addToEnd(4);
        list.addToEnd(2);
        list.addToEnd(2);
        list.addToEnd(2);        
        list.addToEnd(8);
        Assert.assertEquals(8, list.getValue(list.lastPosition()));
    }

    /**
     * Test of insert method, of class UniqueList.
     */
    @Test(expected=ElementExistsInListException.class)
    public void testInsert() throws Exception {
        UniqueList list = new UniqueList();
	list.addToStart(4);
        list.addToStart(6);
        list.addToStart(2);
        list.insert(10, list.firstPosition());
        list.insert(10, list.lastPosition());
        ListElement position = list.firstPosition();
        position = list.nextPosition(position);
        list.insert(8, position);
        Assert.assertEquals(8, list.getValue(position));  
    }

    /**
     * Test of removeElement method, of class UniqueList.
     */
    @Test(expected=RemoveElementNonexistInListException.class)
    public void testRemoveElement() throws Exception {
        UniqueList list = new UniqueList();
        list.addToStart(1);
        list.addToStart(2);
        list.addToStart(3);        
        list.removeElement(4);
        list.removeElement(100000);
        list.removeElement(2);
        ListElement position = list.firstPosition();
        Assert.assertEquals(1, list.getValue(list.nextPosition(position)));
    }
}
