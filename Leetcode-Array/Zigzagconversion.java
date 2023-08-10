import java.util.Arrays;

public class Zigzagconversion {
    public static String convert(String s, int numRows) {
        int n = s.length();
        String newStr = "";

        if (numRows == 1) {
            return s;
        }

        int counter = 0;
        int[] indicator = new int[n];
        Boolean flag = true;

        for (int i = 0; i < n; i++) {
            indicator[i] = counter;
            if (flag) {
                counter++;
            } else {
                counter--;
            }

            if (counter == 0) {
                flag = true;
            } else if (counter == numRows - 1) {
                flag = false;
            } else
                ;
        }

        // System.out.println(Arrays.toString(indicator));

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < n; j++) {
                if (indicator[j] == i) {
                    newStr += s.charAt(j);
                }
            }
        }

        return newStr;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;

        System.out.println(s);

        System.out.println(convert(s, numRows));
    }
}
