public int[] setMismatch(int[] nums) {
    int dup = -1, missing = -1;

    for (int i = 0; i < nums.length; i++) {
        int idx = Math.abs(nums[i]) - 1;

        if (nums[idx] < 0) {
            dup = Math.abs(nums[i]);
        } else {
            nums[idx] = -nums[idx];
        }
    }

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) {
            missing = i + 1;
            break;
        }
    }

    return new int[]{dup, missing};
}

public void main(String[] args) {
    int[] nums = {1,2,2,4};
    int[] result = setMismatch(nums);
    System.out.println(Arrays.toString(result));
}