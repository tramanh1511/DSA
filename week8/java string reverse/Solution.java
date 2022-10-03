import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        if (palindrome(s)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean palindrome(String s) {
        int n = s.length();
        for (int i = 0; i <= n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
