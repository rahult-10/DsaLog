public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> numToIndex = new HashMap<>();
        
    // 1. Iterate over every number in the array
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];

        if (numToIndex.containsKey(complement)) {
            return new int[]{numToIndex.get(complement), i};
        }
            
        numToIndex.put(nums[i], i);
    }
        
    return new int[]{};
}

public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;

    int[] result = twoSum(nums, target);
    System.out.println(Arrays.toString(result));
}