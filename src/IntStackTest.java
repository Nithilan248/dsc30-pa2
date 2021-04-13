import org.junit.Test;

import static org.junit.Assert.*;

public class IntStackTest {
    private IntStack stack1 = new IntStack(8);
    private IntStack stack2 = new IntStack(9);

    @Test
    public void testConstructor() {
        int [] expected = new int[8];
        assertEquals(expected.length , stack1.capacity());
        assertEquals(0,stack1.size());

    }

    @Test
    public void testIsEmpty() {
        boolean expected =  true;
        boolean actual = stack1.isEmpty();
        assertEquals(expected, actual);
    }
//
//    @Test
//    public void testClear() {
//    }
//
//    @Test
//    public void testSize() {
//    }
//
//    @Test
//    public void testCapacity() {
//    }
//
//    @Test
//    public void testPeek() {
//    }
//
//    @Test
//    public void testPush() {
//    }
//
//    @Test
//    public void testPop() {
//    }
//
//    @Test
//    public void testMultiPush() {
//    }
//
//    @Test
//    public void testMultiPop() {
//    }
}