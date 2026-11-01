import java.util.*;
public class weirdAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        StringBuilder sb = new StringBuilder();

        while (true) {
            sb.append(n);

            if (n == 1) {
                break;
            }

            sb.append(" ");

            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
        }

        System.out.println(sb);
        sc.close();
    }
}