public class Main {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";

        Solution solution = new Solution();
        int result = solution.numDistinct(s, t);

        System.out.println("Number of distinct subsequences: " + result);
    }
}
