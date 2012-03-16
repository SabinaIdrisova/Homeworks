package task3;

import org.junit.*;

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


    @Test
    public void TestAddToStartToEmptyList() {
	List list = new List();
	list.addToStart(4);
	ListElement position = list.firstPosition();
	Assert.assertEquals(4, list.getValue(position));
    }
	
    @Test
    public void TestAddToStart() {
        List list = new List();
	list.addToStart(4);
	list.addToStart(8);
	ListElement position = list.firstPosition();
	position = list.nextPosition(position);
	Assert.assertEquals(4, list.getValue(position));
    }

    @Test
    public void TestAddToEnd() {
	List list = new List();
	list.addToEnd(0);
	list.addToEnd(6);
	list.addToEnd(9999);
	ListElement position = list.lastPosition();
	Assert.assertEquals(9999, list.getValue(position));
    }
	
    @Test
    public void TestInsert() {
	List list = new List();
	list.addToStart(4);
        list.addToStart(6);
        list.addToStart(2);
        ListElement position = list.firstPosition();
        position = list.nextPosition(position);
        list.insert(8, position);
        Assert.assertEquals(8, list.getValue(position));  
    }
        
    @Test
    public void TestDeleteFirstElement() {
        List list = new List();
        list.addToStart(4);
        list.addToStart(1);
        list.deleteElement(list.firstPosition());
        Assert.assertEquals(4, list.getValue(list.firstPosition()));
    }
        
    @Test
    public void TestDeleteLastElement() {
        List list = new List();
        list.addToStart(2);
        list.addToStart(8);
        list.deleteElement(list.lastPosition());
        Assert.assertEquals(8, list.getValue(list.lastPosition()));
    }
        
    @Test 
    public void TestDeleteElement() {
        List list = new List();
        list.addToStart(1);
        list.addToStart(2);
        list.addToStart(3);
        ListElement position = list.firstPosition();
        list.deleteElement(list.nextPosition(position));
        Assert.assertEquals(3, list.getValue(position));
    }
        
    @Test
    public void TestLengthOfList() {
        List list = new List();
        list.addToStart(3);
        list.addToStart(3);
        Assert.assertEquals(2, list.lengthOfList());
    }
}

