// LC -> 3736. Minimum Moves to Equal Array Elements III

class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        int steps = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            steps += max - nums[i];
        }

        return steps;
        
    }
}