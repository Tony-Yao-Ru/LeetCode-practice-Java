import java.util.Arrays;

public class JumpGame {
    public static int[] Nums;
    public static Boolean[] Cache;

    public static void main(String[] args) {
        int[] testcase = { 3, 2, 1, 0, 4 };
        System.out.println("Test case is " + Arrays.toString(testcase));

        System.out.println(JumpGame.canJump(testcase));
        System.out.println("Cache = " + Arrays.toString(JumpGame.Cache));
    }

    public static Boolean canJump(int[] nums) {
        JumpGame.Nums = nums;
        int n = nums.length;
        JumpGame.Cache = new Boolean[n];
        return JumpGame.dfs(0);
    }

    private static Boolean dfs(int index) {
        System.out.println("Index= " + String.valueOf(index) + "=> Get started!");
        if (JumpGame.Nums.length - 1 <= index) {
            System.out
                    .println("Index= " + String.valueOf(index) + "=> Determine whether touching the end or not!" + " =>"
                            + "true");
            JumpGame.Cache[index] = true;
            return true;
        }
        System.out.println(
                "Index= " + String.valueOf(index) + "=> Determine whether touching the end or not!" + " =>" + " False");

        if (JumpGame.Cache[index] != null) {
            System.out.println("Index= " + String.valueOf(index) + "=> Give the answer!" + "=>" + JumpGame.Cache[index]);
            return JumpGame.Cache[index];
        }

        int maxJump = JumpGame.Nums[index];

        for (int i = 1; i <= maxJump; i++) {
            System.out.println("Index= " + String.valueOf(index) + "=> Identify the maxJump!" + "=> " + "maxJump="
                    + String.valueOf(maxJump));

            Boolean res = JumpGame.dfs(index + i);

            if (res) {
                JumpGame.Cache[index] = true;
                System.out.println("Index= " + String.valueOf(index) + "=> Write the true to Cache[]!" + "=> Cache="
                        + Arrays.toString(JumpGame.Cache));
                return JumpGame.Cache[index];
            }
        }
        JumpGame.Cache[index] = false;
        System.out.println("Index= " + String.valueOf(index) + "=> Write the false to Cache[]!" + "=> Cache="
                + Arrays.toString(JumpGame.Cache));
        return JumpGame.Cache[index];
    }
}