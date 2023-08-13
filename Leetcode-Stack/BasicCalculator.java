import java.util.*;

public class BasicCalculator {
    static String s;

    public static int calculate(String s) {
        BasicCalculator.s = s;
        BasicCalculator.s = BasicCalculator.s.replaceAll(" ", "");

        // For the case without any operator but numbers
        // test = "123456789" => Output = 123456789
        if (BasicCalculator.s.contains("+") == false && BasicCalculator.s.contains("-") == false
                && BasicCalculator.s.contains("(") == false && BasicCalculator.s.contains(")") == false) {
            return Integer.valueOf(BasicCalculator.s);
        }

        Stack<Integer> stack = new Stack<>();
        char ch;
        int i = 0;

        // For the case which the operator appears in the front of the numbers or the
        // space appears in the front of the number
        // test = "+2-1" => Output = 1
        // test = "1-( -2)" => Output = 3
        if (BasicCalculator.s.charAt(i) == '+' || BasicCalculator.s.charAt(i) == '-') {
            if (stack.size() == 0)
                BasicCalculator.s = '0' + BasicCalculator.s;
        }

        while (i < BasicCalculator.s.length()) {
            i = 0;
            ch = BasicCalculator.s.charAt(i);
            if (ch == '+') {
                // 1 assigns to plus
                stack.push(1);
                BasicCalculator.s = BasicCalculator.s.substring(i + 1, BasicCalculator.s.length());
            } else if (ch == '-') {
                // 0 assigns to minus
                stack.push(0);
                BasicCalculator.s = BasicCalculator.s.substring(i + 1, BasicCalculator.s.length());
            } else if (ch == '(') {
                // For the case the operator appears in the following of '('
                // test = "2+(-3+2)" => Output = 1
                if (BasicCalculator.s.charAt(i + 1) == '+' || BasicCalculator.s.charAt(i + 1) == '-') {
                    BasicCalculator.s = '0' + BasicCalculator.s.substring(i + 1, BasicCalculator.s.length());
                } else {
                    BasicCalculator.s = BasicCalculator.s.substring(i + 1, BasicCalculator.s.length());
                }
                System.out.println("Go to the sub-problem!!!");
                stack.push(calculate(BasicCalculator.s));
            } else if (ch == ')') {
                BasicCalculator.s = BasicCalculator.s.substring(i + 1, BasicCalculator.s.length());
                System.out.println("Return to the previous sub-problem!!!");
                return stack.pop();
            } else {
                // For the case that the digit of the number is greater than 1
                // test = "1+11" => Output = 12
                int j = i + 1;
                if (j != BasicCalculator.s.length()) {
                    while (BasicCalculator.s.charAt(j) != '+' && BasicCalculator.s.charAt(j) != '-'
                            && BasicCalculator.s.charAt(j) != ')') {
                        j = j + 1;
                        if (j == BasicCalculator.s.length())
                            break;
                    }
                }
                if (j - 1 == i) {
                    stack.push(Character.getNumericValue(ch));
                    BasicCalculator.s = BasicCalculator.s.substring(i + 1, BasicCalculator.s.length());
                } else {
                    String str = BasicCalculator.s.substring(i, j);
                    stack.push(Integer.valueOf(str));
                    BasicCalculator.s = BasicCalculator.s.substring(j, BasicCalculator.s.length());
                }
            }

            // System.out.println("s = " + s);
            System.out.println("Stack = " + stack);

            // Check every three elements in the stack
            // stack = [val1, operator(0 or 1), val2]
            if (stack.size() == 3) {
                int val2 = stack.pop();
                if (stack.pop() == 0)
                    val2 = 0 - val2;
                int val1 = stack.pop();
                stack.push(val1 + val2);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String test = "(1+(4+5+2)-3)+(6+8)";
        // String test = "1-11";
        // String test = "-2+ 1";
        // String test = "1-( -2)";
        System.out.println("The problem = " + test);
        System.out.println(calculate(test));
    }
}
