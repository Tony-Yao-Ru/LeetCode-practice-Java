import java.util.*;

public class SimplifyPath {
    static String simplifyPath(String path) {
        String[] arr = path.split("/");
        System.out.println(Arrays.toString(arr));
        // Stack<String> stack = new Stack<>();
        Deque<String> deque = new ArrayDeque<String>();

        for (String str : arr) {
            if (str.isEmpty() || str.equals("."))
                continue;

            if (str.equals("..")) {
                if (!deque.isEmpty())
                    deque.removeLast();
            } else {
                deque.add(str);
            }
        }
        return "/" + String.join("/", deque);
    }

    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";

        System.out.println(path);
        System.out.println(simplifyPath(path));
    }
}
