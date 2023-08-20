import java.util.*;

public class FindSubstring {
    static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int left, right = 0;
        int length = s.length();
        int wordLen = words[0].length();
        int tarLen = wordLen * words.length;
        int count;

        HashMap<String, Integer> table;
        HashMap<String, Integer> lookuptable = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            lookuptable.put(words[i], lookuptable.getOrDefault(words[i], 0) + 1);
        }
        count = lookuptable.size();
        table = new HashMap<>(lookuptable);

        while (right <= length - tarLen) {
            String test = s.substring(right, right + tarLen);
            left = 0;
            System.out.println("The test is " + test);
            while (left < tarLen) {
                String subtest = test.substring(left, left + wordLen);
                System.out.println("The subtest is " + subtest);
                if (table.containsKey(subtest)) {
                    table.put(subtest, table.getOrDefault(subtest, 0) - 1);
                    if (table.get(subtest) == 0)
                        count--;
                }
                left += wordLen;
            }
            System.out.println("The test is over!" + Integer.toString(count));

            if (count == 0) {
                result.add(right);
            }

            table = new HashMap<>(lookuptable);
            count = table.size();
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        // String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        // String[] words = { "fooo", "barr", "wing", "ding", "wing" };
        String s = "wordgoodgoodgoodbestword";
        String[] words = { "word", "good", "best", "good" };

        System.out.println(findSubstring(s, words));
    }
}
