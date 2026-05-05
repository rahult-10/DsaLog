public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int len = 0;

    for (int num : nums) {
        int left = 0, right = len;

        while (left < right) {
            int mid = (left + right) / 2;
            if (tails[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        tails[left] = num;
        if (left == len)
            len++;
    }

    return len;
}

public void main(String[] args){
    int[] nums = {10,9,2,5,3,7,101,18};
    int result = lengthOfLIS(nums);
    System.out.println(result);
}