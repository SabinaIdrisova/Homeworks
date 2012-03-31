/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3t3;

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
        HashTable hash = new HashTable();
        String word = "ok";
        hash.addEl(word);
        assertTrue(hash.findElement(word));
    }

    /**
     * Test of delEl method, of class HashTable.
     */
    @Test
    public void testDelEl() {
       HashTable hash = new HashTable();
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
        HashTable hash = new HashTable();
        String word = "ok";
        Assert.assertEquals(false, hash.findElement(word));
    }
}
