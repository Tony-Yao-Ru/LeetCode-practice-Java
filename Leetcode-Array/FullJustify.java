import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class FullJustify {
    static public List<String> fulljustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int numSpace = 1;
        String str = words[0];
        Boolean flagLast = false;

        if (n == 1) {
            flagLast = true;
            result.add(organize(str, maxWidth, flagLast));
            return result;
        }

        for (int i = 1; i < n; i++) {
            // Estimate the width when adding the word
            if (str.length() + numSpace + words[i].length() > maxWidth) {
                // System.out.println(str);
                result.add(organize(str, maxWidth, flagLast));
                str = words[i];
            } else {
                str = str + " " + words[i];
            }

            // identify whether this line is the last or not
            if (i == n - 1) {
                flagLast = true;
                result.add(organize(str, maxWidth, flagLast));
            }
        }

        return result;
    }

    static private String organize(String str, int maxWidth, Boolean flagLast) {
        if (!flagLast) {
            // Organize the line which is not the last
            String[] buffer = str.split(" ");
            int numWord = buffer.length;

            if (numWord == 1) {
                int restSpace = maxWidth - str.length();
                for (int i = 0; i < restSpace; i++) {
                    str += " ";
                }
                return str;
            }

            // Calculate how many spaces are required to add between words
            int restSpace = maxWidth - str.length() + (numWord - 1);
            int AvgNumSpace = restSpace / (numWord - 1);
            int ExtraNumSpace = restSpace % (numWord - 1);

            str = "";
            for (int j = 0; j < numWord - 1; j++) {
                str += buffer[j];
                for (int i = 0; i < AvgNumSpace; i++) {
                    str += " ";
                }
                if (ExtraNumSpace > 0) {
                    str += " ";
                    ExtraNumSpace--;
                }
            }
            str += buffer[numWord - 1];
            return str;

        } else {
            // Organize the last line
            int restSpace = maxWidth - str.length();
            for (int i = 0; i < restSpace; i++) {
                str += " ";
            }
            return str;
        }
    }

    static public void main(String[] args) {
        String[] words = { "What", "must", "be", "acknowledgment", "shall", "be" };
        int maxWidth = 16;
        System.out.println(Arrays.toString(words));

        System.out.println(fulljustify(words, maxWidth));
    }
}