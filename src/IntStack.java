/*
    Name: Nithilan Muruganandham
    PID:  A16668306
 */

import java.util.EmptyStackException;

/**
 * Making a stack for integers by using an integer array
 * @author Nithilan Muruganandham
 * @since  ${04/12/2-21}
 */
public class IntStack {
    private static final int FACTR = 2;

    /* instance variables, feel free to add more if you need */
    private int[] data;
    private int nElems;
    private double loadFactor;
    private double shrinkFactor;
    private int initialCap;

    public IntStack(int capacity, double loadF, double shrinkF) {
        /**
         * Initializes a new stack of Integers
         * @param capacity the capacity of the stack
         * @param loadf the load factor
         * @param shrinkF the shrink factor
         * @throws IllegalArgumentException when the requirements for the parameter arent met
         */
        if (capacity >= 5 || (.67 <= loadF && loadF <= 1) || (0 < shrinkF && shrinkF <= .33)) {
            throw new IllegalArgumentException();
        }
        loadFactor = loadF;
        shrinkFactor = shrinkF;
        data = new int[capacity];
        initialCap = capacity;


    }

    public IntStack(int capacity, double loadF) {
        /**
         * Initializes a new stack of Integers
         * @param capacity the capacity of the stack
         * @param loadf the load factor
         * @throws IllegalArgumentException when the requirements for the parameter arent met
         */
        this(capacity, loadF, .25);

    }

    public IntStack(int capacity) {
        /**
         * Initializes a new stack of Integers
         * @param capacity the capacity of the stack
         * @throws IllegalArgumentException when the requirements for the parameter arent met
         */
        this(capacity, .75, .25);
    }

    public boolean isEmpty() {
        /**
         * Checks if the boolean is empty
         * @return ture if there is nothing in the stack, false otherwise
         */
        return nElems == 0;
    }

    public void clear() {
        /**
         * clears the elements in the stack
         */
        data = new int[initialCap];
    }

    public int size() {
        /**
         * number of elements in the stack
         * @return the number elements
         */
        return nElems;
    }

    public int capacity() {
        /**
         * the maximum number of integers that can be stored
         * @return length of the array
         */
        return data.length;
    }

    public int peek() {
        /**
         * returns the top of the stack
         * @return the top element of the stack
         * @throws EmptyStackException when the stack is empty
         */
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[nElems - 1];
    }

    public void push(int element) {
        /**
         * Adds the element to the stack
         * @param element what to put in the stack
         */
        if (nElems / data.length >= loadFactor) {
            int[] nData = new int[data.length * FACTR];
            for (int i = 0; i < data.length; i++) {
                nData[i] = data[i];
            }
            data = nData;
        }
        data[nElems] = element;
        nElems++;
    }

    public int pop() {
        /**
         * Removes the last element of the stack
         * @return the last element of the stack
         */
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        if (nElems / data.length <= shrinkFactor) {
            int[] nData = new int[data.length / FACTR];
            for (int i = 0; i < data.length; i++) {
                nData[i] = data[i];
            }
            data = nData;
        }
        nElems--;
        return data[nElems];
    }

    public void multiPush(int[] elements) {
        /**
         * pushes all the numbers in the array to the stack
         * @param elements the array of ints
         * @throws IllegalArgumentException if elements is null
         */
        if (elements == null) {
            throw new IllegalArgumentException();
        }
        for (int num: elements) {
            push(num);
        }
    }

    public int[] multiPop(int amount) {
        /**
         * Pop the number of elements given
         * @param amount the number of elements popped
         * @throws IllegalArgumentException when amount isn't positive
         */
        int[] popped;
        if (amount > nElems) {
            popped = new int[nElems];
            int count = 0;
            while (nElems != 0) {
                popped[count] = pop();
                count++;
            }
        } else {
            popped = new int[amount];
            for (int i = 0; i < amount; i++) {
                popped[i] = pop();
            }
        }
        return popped;
    }
}
