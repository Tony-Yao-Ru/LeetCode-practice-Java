import java.util.*;

public class MinWindow {
    static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> lookuptable = new HashMap<>();
        int right = 0, left = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = left;
        int count = 0;
        int length = s.length();

        for (int i = 0; i < t.length(); i++) {
            lookuptable.put(t.charAt(i), lookuptable.getOrDefault(t.charAt(i), 0) + 1);
        }
        count = lookuptable.size();

        while (right < length) {
            // Right ptr goes first.
            Character test = s.charAt(right);
            if (lookuptable.containsKey(test)) {
                lookuptable.put(test, lookuptable.get(test) - 1);
                if (lookuptable.get(test) == 0) {
                    count--;
                }
            }

            while (count <= 0) {
                // minIndex = left;
                // min = Math.min(min, right-minIndex+1);
                Character subtest = s.charAt(left);
                if (lookuptable.containsKey(subtest)) {
                    lookuptable.put(subtest, lookuptable.get(subtest) + 1);
                    if (lookuptable.get(subtest) > 0) {
                        count++;
                    }
                }
                if (right - left < min) {
                    minIndex = left;
                    min = right - left + 1;
                }
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(minIndex, minIndex + min);
    }

    public static void main(String[] args) {
        // String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        // String[] words = { "fooo", "barr", "wing", "ding", "wing" };
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}
