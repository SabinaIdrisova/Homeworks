
package hw3t4;

import org.junit.*;
import static org.junit.Assert.*;

public class HashFunction1Test {
    
    public HashFunction1Test() {
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
     * Test of hashFunction method, of class HashFunction1.
     */
    @Test
    public void testHashFunction() {
        int hashLength = 40;
        String word = "ok";
        HashFunction1 function = new HashFunction1();
        Assert.assertEquals(word.hashCode() % hashLength, function.hashFunction(word, hashLength));
    }
}
