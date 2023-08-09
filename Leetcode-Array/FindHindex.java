import java.util.Arrays;

class FindHindex {
    public static int findHindex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        System.out.println(Arrays.toString(papers));
        // counting papers for each citation number
        for (int c : citations) {
            papers[Math.min(n, c)]++;
            System.out.println(Arrays.toString(papers));
        }
        // finding the h-index
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k]) {
            System.out.println("s=" + Integer.toString(s));
            System.out.println("k=" + Integer.toString(k));
            k--;
        }
        return k;
    }

    public static void main(String args[]) {
        int[] arr = { 1, 3, 1 };
        System.out.println(Arrays.toString(arr));
        System.out.println(findHindex(arr));
    }
}