package hw2t1;

import org.junit.*;
import static org.junit.Assert.*;

public class RobotsGraphTest {
    
    public RobotsGraphTest() {
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
     * Test of checkDestroyed method, of class RobotsGraph.
     */
    @Test
    public void testCheckDestroyed1() {
        boolean[][] graph = {
            {false, true, false, false},
            {true, false, true, false},
            {false, true, false, true},
            {false, false, true, false}
        };
        boolean[] robotsInVertices = {false, true, true, false};
        RobotsGraph robots = new RobotsGraph(graph, robotsInVertices);
        assertFalse(robots.checkDestroyed());
    }
    
    /**
     * Test of checkDestroyed method, of class RobotsGraph.
     */
    @Test
    public void testCheckDestroyed2() {
        boolean[][] graph = {
            {false, true, false, false},
            {true, false, true, false},
            {false, true, false, true},
            {false, false, true, false}
        };
        boolean[] robotsInVertices = {false, true, false, true};
        RobotsGraph robots = new RobotsGraph(graph, robotsInVertices);
        assertTrue(robots.checkDestroyed());
    }
}
