package hw1t2;

import org.junit.*;
import static org.junit.Assert.*;

public class NetworkTest {
    
    public NetworkTest() {
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
     * Test of addComputer method, of class Network.
     */
    @Test
    public void testAddComputer() {
        Network network = new Network();
        Computer comp1 = new Computer(new Windows(), "comp1");
        network.addComputer(comp1);
        assertEquals(network.getNotInfectedComputers().get(0), comp1);
    }

}
