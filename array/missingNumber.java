import java.util.*;
public class missingNumber {

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int actualSum = n * (n + 1) / 2;

        return actualSum - sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(missingNumber(nums));
    }
}