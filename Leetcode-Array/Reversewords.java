public class Reversewords {
    public static String reverseWords(String s) {
        s = s.trim();
        s += ' ';
        s = cleanMoreSpace(s);
        s = reverse(s);
        s = s.trim();
        return s;
    }

    private static String cleanMoreSpace(String s) {
        int n = s.length();
        String newStr = "";
        int ptr1 = 0;
        int ptr2 = ptr1;
        while (ptr2 < s.length()) {
            if (s.charAt(ptr2) == ' ') {
                newStr += reverse(s.substring(ptr1, ptr2));
                newStr += ' ';
                while (ptr2 < s.length() && s.charAt(ptr2) == ' ') {
                    ptr2++;
                }
                ptr1 = ptr2;
            } else {
                ptr2++;
            }
        }
        return newStr;
    }

    private static String reverse(String test) {
        int ptr_left = 0;
        int ptr_right = test.length() - 1;
        while (ptr_left < ptr_right) {
            test = swap(test, ptr_left, ptr_right);
            ptr_left++;
            ptr_right--;
        }
        return test;
    }

    private static String swap(String str, int i, int j) {
        if (j == str.length() - 1)
            return str.substring(0, i) + str.charAt(j)
                    + str.substring(i + 1, j) + str.charAt(i);

        return str.substring(0, i) + str.charAt(j)
                + str.substring(i + 1, j) + str.charAt(i)
                + str.substring(j + 1, str.length());
    }

    public static void main(String[] args) {
        String myStr = "       Hello World!        ";
        System.out.println(reverseWords(myStr));
    }
}