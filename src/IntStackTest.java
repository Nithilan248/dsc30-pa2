import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class IntStackTest {
    private IntStack stack1 = new IntStack(8);
    private IntStack stack2 = new IntStack(18,.83);
    private IntStack stack3 = new IntStack(20,.9,.24);

    @Test
    public void testConstructor1() {
        assertEquals(8 , stack1.capacity());
        assertEquals(18, stack2.capacity());
        assertEquals(20, stack3);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor2() {
        IntStack stack = new IntStack(3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructor3() {
        IntStack stack = new IntStack(6, 1.1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructor4() {
        IntStack stack = new IntStack(7,.75,.5);
    }

    @Test
    public void testIsEmpty() {
        boolean expected =  true;
        boolean actual = stack1.isEmpty();
        assertEquals(expected, actual);
        assertEquals(expected, stack2.isEmpty());
        assertEquals(expected, stack3.isEmpty());

    }
    @Test
    public void testPush() {
        stack1.push(5);
        assertEquals(5, stack1.peek());
        stack1.push(6); stack1.push(8); stack1.push(9);
        assertEquals(4, stack1.size());
        assertEquals(9, stack1.peek());
    }
    @Test
    public void testMultiPush1() {
        int [] x = {2,3,4,5,6,7,8,9};
        stack2.multiPush(x);
        assertEquals(8,stack2.size());
        assertEquals(9,stack2.peek());
        stack1.multiPush(x);
        stack1.multiPush(x);
        assertEquals(16, stack1.size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testMultiPush2() {
        stack1.multiPush(null);
    }

    @Test
    public void testSize() {
        int [] x = {2,3,4,5,6,7,8,9};
        stack2.multiPush(x);
        stack1.multiPush(x);
        stack1.multiPush(x);
        assertEquals(16, stack1.size());
        assertEquals(8, stack2.size());
        assertEquals(0, stack3.size());
    }

    @Test
    public void testClear() {
        stack1.clear();
        stack2.clear();
        assertEquals(0, stack1.size());
        assertEquals(8, stack1.capacity());
        assertEquals(18, stack2.capacity());
    }


    @Test (expected = EmptyStackException.class)
    public void testPeek() {
        stack1.peek();
    }



    @Test
    public void testPop1() {
        int [] x = {2,3,4,5,6,7,8,9};
        stack1.multiPush(x);
        stack1.multiPush(x);
        assertEquals(9, stack1.pop());
        assertEquals(15, stack1.size());
        assertEquals(8,stack1.pop());
    }
    @Test (expected = EmptyStackException.class)
    public void testPop2() {
        stack1.pop();
    }
    @Test (expected = IllegalArgumentException.class)
    public void testMultiPop1() {
        stack1.multiPop(-5);
    }



    @Test
    public void testMultiPop() {
        int [] x = {2,3,4,5,6,7,8,9};
        stack1.multiPush(x);
        stack1.multiPush(x);
        int [] y = {9,8,7,6};
        int [] z = {5};
        int [] a = {4,3,2,9,8};
        assertArrayEquals(y,stack1.multiPop(4));
        assertArrayEquals(z, stack1.multiPop(1));
        assertArrayEquals(a, stack1.multiPop(5));
    }
}