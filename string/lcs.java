// Longest Common SubSequence 

public static int lcs(String text1, String text2) {
    return helper(text1, text2, text1.length(), text2.length());
}

private static int helper(String text1, String text2, int m, int n) {
    if (m == 0 || n == 0) 
        return 0;

    if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
        return 1 + helper(text1, text2, m - 1, n - 1);
    }

    return Math.max(
        helper(text1, text2, m - 1, n),
        helper(text1, text2, m, n - 1)
    );
}

public static void main(String[] args) {
    String text1 = "abcde";
    String text2 = "ace";

    System.out.println("LCS Length: " + lcs(text1, text2));
}