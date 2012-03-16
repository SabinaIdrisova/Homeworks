package task4;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class StackTest {

	@Test
	public void testPush() {
		Stack stack = new Stack();
		stack.push(1);
		Assert.assertEquals(1, stack.top());
	}
	
	@Test
	public void testPop() {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		Assert.assertEquals(2, stack.pop());	
	}
	
	@Test
	public void testPopIfStackIsEmpty() {
		Stack stack = new Stack();
		Assert.assertEquals(-1, stack.pop());
	}
	
	@Test
	public void testIsEmptyIfStackIsEmpty() {
		Stack stack = new Stack();
	    assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testIsEmpty() {
		Stack stack = new Stack();
		stack.push(0);
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void testTopIfStackIsEmpty() {
		Stack stack = new Stack();
		Assert.assertEquals(-1, stack.top());
	}
	
	@Test 
	public void testTop() {
		Stack stack = new Stack();
		stack.push(4);
		stack.push(16);
		Assert.assertEquals(16, stack.top());
	}
}
