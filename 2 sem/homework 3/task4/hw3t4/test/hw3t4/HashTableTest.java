package hw3t4;

import org.junit.*;
import static org.junit.Assert.*;


public class HashTableTest {
    
    public HashTableTest() {
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
     * Test of addEl method, of class HashTable.
     */
    @Test
    public void testAddEl() {
        HashFunction1 function = new HashFunction1();
        HashTable hash = new HashTable();
        hash.setHashFunction(function);
        String word = "ok";
        hash.addEl(word);
        assertTrue(hash.findEl(word));
        HashFunction2 function2 = new HashFunction2();
        hash.setHashFunction(function2);
        assertFalse(hash.findEl("hoho"));
    }

    /**
     * Test of delEl method, of class HashTable.
     */
    @Test
    public void testDelEl() {
       HashFunction1 function = new HashFunction1();
       HashTable hash = new HashTable();
       hash.setHashFunction(function);
       String word = "ok";
       hash.addEl(word);
       hash.delEl(word);
       assertFalse(hash.findEl(word));
       HashFunction2 function2 = new HashFunction2();
       hash.setHashFunction(function2);
       hash.addEl(word);
       assertTrue(hash.findEl(word));
    }

    /**
     * Test of findElement method, of class HashTable.
     */
    @Test
    public void testFindEl() {
        HashFunction1 function = new HashFunction1();
        HashTable hash = new HashTable();
        hash.setHashFunction(function);
        String word = "ok";
        Assert.assertEquals(false, hash.findEl(word));
        HashFunction2 function2 = new HashFunction2();
        hash.setHashFunction(function2);
        hash.addEl(word);
        assertTrue(hash.findEl(word)); 
    }
    
    /**
     * Test of setHashFunction method, of class HashTable
     */
    @Test
    public void testSetHashFunction() {
        HashFunction1 function = new HashFunction1();
        HashTable hash = new HashTable();
        hash.setHashFunction(function);
        hash.addEl("ok");
        Assert.assertEquals(true, hash.findEl("ok"));
        HashFunction2 function2 = new HashFunction2();
        hash.setHashFunction(function2);
        assertTrue(hash.findEl("ok"));
        hash.addEl("1");
        assertTrue(hash.findEl("1"));
        hash.setHashFunction(function);
        assertTrue(hash.findEl("1"));     
    }
}
