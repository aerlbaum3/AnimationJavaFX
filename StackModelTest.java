package application;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StackModelTest {
    private StackModel stack;

    @Before
    public void setUp() {
        stack = new StackModel();
    }

    @Test
    public void testEmptyStack() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPushAndPop() {
        stack.push(1);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testMultiplePushAndPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test(expected = IllegalStateException.class)
    public void testPopEmptyStack() {
        stack.pop();
    }
}
