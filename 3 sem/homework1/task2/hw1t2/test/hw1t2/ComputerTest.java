package hw1t2;

import org.junit.*;
import static org.junit.Assert.*;

public class ComputerTest {
    
    public ComputerTest() {
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
     * Test of getName method, of class Computer.
     */
    @Test
    public void testGetName() {
        Computer computer = new Computer(new Windows(), "comp1");
        assertEquals(computer.getName(), "comp1");
    }

    /**
     * Test of getOS method, of class Computer.
     */
    @Test
    public void testGetOS() {
        OS windows = new Windows();
        Computer computer = new Computer(windows, "comp1");
        assertEquals(computer.getOS(), windows);
    }

    /**
     * Test of isInfected method, of class Computer.
     */
    @Test
    public void testIsInfected() {
        Computer computer = new Computer(new Windows(), "comp1");
        assertFalse(computer.isInfected());
        computer.setInfected();
        assertTrue(computer.isInfected());
    }

    /**
     * Test of setInfected method, of class Computer.
     */
    @Test
    public void testSetInfected() {
        Computer computer = new Computer(new Windows(), "comp1");
        assertFalse(computer.isInfected());
        computer.setInfected();
        assertTrue(computer.isInfected());
    }

    /**
     * Test of connect method, of class Computer.
     */
    @Test
    public void testConnect() {
        Computer computer1 = new Computer(new Windows(), "comp1");
        Computer computer2 = new Computer(new Windows(), "comp2");
        computer1.connect(computer2);
        assertEquals(computer1.getConnections().get(0), computer2);
        assertEquals(computer2.getConnections().get(0), computer1);
    }
}
