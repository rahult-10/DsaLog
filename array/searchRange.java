
public int[] searchRange(int[] nums, int target) {
    int[] result = {
        IntStream.range(0, nums.length)
                .filter(i-> nums[i] == target)
                .findFirst()
                .orElse(-1),
        IntStream.iterate(nums.length-1, i->i-1)
                .limit(nums.length)
                .filter(i-> nums[i] == target)
                .findFirst()
                .orElse(-1),
    };
    return result;
}

//OR -> Binary Search
public int[] search(int[] nums, int target) {
    return new int[]{find(nums, target, true), find(nums, target, false)};
}

private int find(int[] nums, int target, boolean first) {
    int left = 0, right = nums.length - 1;
    int ans = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            ans = mid;
            if (first){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        } 
        else if (nums[mid] < target) {
            left = mid + 1;
        } 
            else {
            right = mid - 1;
        }
    }
    return ans;
}


public void main(String[] args) {
    int[] nums = {5, 7, 7, 8, 8, 10};
    int target = 8;
    System.out.println(Arrays.toString(searchRange(nums, target)));
}
