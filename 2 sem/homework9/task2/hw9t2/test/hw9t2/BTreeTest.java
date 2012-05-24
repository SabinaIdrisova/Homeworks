package hw9t2;


import org.junit.*;
import static org.junit.Assert.*;

public class BTreeTest {
    
    public BTreeTest() {
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
     * Test of add method, of class BTree.
     */
    @Test
    public void testAdd() {
        BTree tree = new BTree(1);
        tree.add(1, 2);
        tree.add(2, 3);
        tree.add(3, 4);
        assertEquals(2, tree.search(tree.getRoot(), 1));
        assertEquals(3, tree.search(tree.getRoot(), 2));
        assertEquals(4, tree.search(tree.getRoot(), 3));
    }

    /**
     * Test of split method, of class BTree.
     */
    @Test
    public void testSplit() {
        BTree tree = new BTree(1);
        tree.add(1, 2);
        tree.add(2, 3);
        tree.split(tree.getRoot());
        assertEquals(2, tree.getRoot().getKey(0));
        assertEquals(1, tree.getRoot().getChild(0).getKey(0));
    }

    /**
     * Test of search method, of class BTree.
     */
    @Test
    public void testSearch() {
        BTree tree = new BTree(1);
        tree.add(1, 200);
        tree.add(2, 310);
        tree.add(3, 100500);
        assertEquals(200, tree.search(tree.getRoot(), 1));
        assertEquals(310, tree.search(tree.getRoot(), 2));
        assertEquals(100500, tree.search(tree.getRoot(), 3));
    }

    /**
     * Test of getRoot method, of class BTree.
     */
    @Test
    public void testGetRoot() {
        BTree tree = new BTree(1);
        tree.add(1, 2);
        tree.add(2, 3);
        tree.add(3, 4);
        tree.add(4, 5);
        assertEquals(2, tree.getRoot().getKey(0));
        tree.add(6, 3);
        tree.add(5, 7);
        assertEquals(2, tree.getRoot().getKey(0));
        assertEquals(4, tree.getRoot().getKey(1));
    }
}
