/*
    Name: Nithilan Muruganandham
    PID:  A16668306
 */

/**
 * Used to convert Prefix Notation to a value
 * @author Nithilan Murugananddham
 * @since  since ${04/12/2021}
 */
public class PrefixNotation {


    public static int evaluate(String notation) {
        /**
         * Takes a string in prefix notation and uses it to find a value
         * @param notation a string in prefix notation
         * @return the vale of the expression given in prefix notation
         */
        IntStack ints = new IntStack(100);
        for (int i = notation.length() - 1; i >= 0; i--) {
            char c = notation.charAt(i);
            if (c >= 48 && c <= 57) {
                ints.push((int) (c - 48));
            } else {
                int num1 = ints.pop();
                int num2 = ints.pop();
                switch (c) {
                    case '+':
                        ints.push(num1 + num2);
                        break;
                    case '-':
                        ints.push(num1 - num2);
                        break;
                    case '/':
                        ints.push(num1 / num2);
                        break;
                    case '*':
                        ints.push(num1 * num2);
                        break;
                    default:
                        break;
                }
            }

        }
        return ints.peek();
    }
}
