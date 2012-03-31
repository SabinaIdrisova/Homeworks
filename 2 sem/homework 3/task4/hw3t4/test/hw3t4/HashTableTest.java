
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
        HashTable hash = new HashTable(function);
        String word = "ok";
        hash.addEl(word);
        assertTrue(hash.findElement(word));
    }

    /**
     * Test of delEl method, of class HashTable.
     */
    @Test
    public void testDelEl() {
       HashFunction1 function = new HashFunction1();
       HashTable hash = new HashTable(function);
       String word = "ok";
       hash.addEl(word);
       hash.delEl(word);
       assertFalse(hash.findElement(word));
    }

    /**
     * Test of findElement method, of class HashTable.
     */
    @Test
    public void testFindElement() {
        HashFunction1 function = new HashFunction1();
        HashTable hash = new HashTable(function);
        String word = "ok";
        Assert.assertEquals(false, hash.findElement(word));
    }
}
