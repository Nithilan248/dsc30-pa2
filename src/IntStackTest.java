import org.junit.Test;

import static org.junit.Assert.*;

class IntStackTest {
    private IntStack stack;

    @Test
    public void testConstructor() {
        stack = new IntStack(8);
        int [] expected = new int[8];
        double lf = .75;
        double sf = .25;
        assertEquals(expected.length , stack.capacity());
        assertEquals(0,stack.size());


    }

//    @Test
//    public void testIsEmpty() {
//
//    }
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