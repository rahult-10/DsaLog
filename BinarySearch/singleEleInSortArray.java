class BinarySearch {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
            else if(i == n-1){
                if(nums[i] != nums[i - 1]){
                    return nums[i];
                }
            }
            else {
                if(nums[i] != nums[i+1] && nums[i] != nums[i-1]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
}