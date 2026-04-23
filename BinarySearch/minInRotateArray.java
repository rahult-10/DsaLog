//Find Minimum in Rotated Sorted Array
public int minInRotateArray(int[] nums) {
    int n = nums.length;
    int low = 0;
    int high = n-1;
    int ans = Integer.MAX_VALUE;
    while(low <= high){
        int mid = low + (high-low)/2;

        if(nums[low] <= nums[mid]){
            ans = Math.min(ans, nums[low]);
            low = mid + 1;
        }
        else {
            ans = Math.min(ans, nums[mid]);
            high = mid-1;
        }
    }
    return ans;
}

public void main(String[] args) {
    int[] arr = {3,4,5,1,2};
    int result = minInRotateArray(arr);
    System.out.println(result);
}