/*
    Name: Nithilan Muruganandham
    PID:  A16668306
 */

import java.util.EmptyStackException;

/**
 * A text editor with a redo and undo function
 *
 * @author Nithilan Muruganandham
 * @since TODO
 */
public class TextEditor {

    /* instance variables */
    private String text;
    private IntStack undo;
    private StringStack deletedText;
    private IntStack redo;
    private StringStack insertedText;
    private boolean outOfUndo;

    public TextEditor() {
        /**
         * Initializes a text editor
         */
        text = "";
        undo = new IntStack(10);
        redo = new IntStack(10);
        deletedText = new StringStack(10);
        insertedText = new StringStack(10);
        outOfUndo = true;
    }

    public String getText() {
        /**
         * return the text
         * @return text
         */
        return text;
    }

    public int length() {
        /**
         * gives the length of the text
         * @return the length of the text
         */
        return text.length();
    }

    public void caseConvert(int i, int j) {
        /**
         * Swap the case from the postion i to j
         * @return the string with the cases swapped
         * @throw IllegalArgumentException if i or j is out of bounds or i isnt smaller than j
         */
        if (i >= j || i < 0 || j >= text.length()) {
            throw new IllegalArgumentException();
        }
        if (outOfUndo) {
            redo.clear();
        }
        String swapped = "";
        for (int x = 0; x < text.length(); x++) {
            char c = text.charAt(x);
            String s = text.substring(x, x + 1);
            if (x >= i && x < j) {
                if (Character.isLowerCase(c)) {
                    s = s.toUpperCase();
                } else if (Character.isUpperCase(c)) {
                    s = s.toLowerCase();
                }
            }
            swapped = swapped + s;
        }
        text = swapped;
        int[] history = {i, j, 0};
        undo.multiPush(history);
    }


    public void insert(int i, String input) {
        /**
         * Insert the string to the position given
         * @throw NullPointerException if input is null
         * @throw IllegalArgumentException if i is out bound
         */
        if (input == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i >= text.length()) {
            throw new IllegalArgumentException();
        }
        if (outOfUndo) {
            redo.clear();
        }
        text = text.substring(0, i) + input + text.substring(i);
        int[] history = {i, i + input.length(), 1};
        undo.multiPush(history);
        insertedText.push(input);
    }

    public void delete(int i, int j) {
        /**
         * delete the characters from position i to j
         * @throw IllegalArgumentException if i or j is out of bounds or i isnt smaller than j
         */
        String x = "";
        if (i >= j || i < 0 || j >= text.length()) {
            throw new IllegalArgumentException();
        }
        if (outOfUndo) {
            redo.clear();
        }
        x = x + text.substring(i, j);
        deletedText.push(x);
        text = text.substring(0, i) + text.substring(j);

        int[] history = {i, j, 2};
        undo.multiPush(history);

    }

    public boolean undo() {
        /**
         * Updates the text by undoing the latest operation
         * @return false if theres no operation, true if it's successful
         */
        int[] history;
        try {
            history = undo.multiPop(3);
        } catch (EmptyStackException e) {
            return false;
        }
        outOfUndo = false;
        int[] forRedo = {history[2], history[1], history[0]};
        redo.multiPush(forRedo);

        switch (history[0]) {
            case 0:
                caseConvert(history[2], history[1]);
                break;
            case 1:
                delete(history[2], history[1]);
                break;
            case 2:
                insert(history[2], deletedText.pop());
                break;
            default:
                break;
        }
        outOfUndo = true;
        return true;
    }

    public boolean redo() {
        /**
         * Perform operations that have been undone
         * @return false if performing a redo fails, true otherwise
         */
        int[] history;
        try {
            history = undo.multiPop(3);
        } catch (EmptyStackException e) {
            return false;
        }
        outOfUndo = false;
        switch (history[0]) {
            case 0:
                caseConvert(history[2], history[1]);
                break;
            case 1:
                insert(history[2], deletedText.pop());
                break;
            case 2:
                delete(history[2], history[1]);
                break;
            default:
                break;
        }
        outOfUndo = true;
        return true;
    }
}
