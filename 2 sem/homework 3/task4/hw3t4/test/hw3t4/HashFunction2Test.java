package hw3t4;

import org.junit.*;
import static org.junit.Assert.*;

public class HashFunction2Test {
    
    public HashFunction2Test() {
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
     * Test of hashFunction method, of class HashFunction2.
     */
    @Test
    public void testHashFunction() {
        int hashLength = 40;
        String str = "ok";
        HashFunction2 function = new HashFunction2();
        char[] word = new char[str.length()];
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            word[i] = str.charAt(i);
            if ((word[i] >= 'A' && word[i] <= 'Z') || (word[i] >= 'a' && word[i] <= 'z'))
                    result = (result + word[i]) % hashLength;
        }
        Assert.assertEquals(result, function.hashFunction(str, hashLength));
    }
}
