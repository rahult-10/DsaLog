public int search(int[] nums, int target) {
    int n = nums.length;
    for(int i = 0; i < n; i++){
        if(nums[i] == target){
            return i;
        }
    }
    return -1;
}

public int binarySearch(int[] nums, int target){
    int n = nums.length;
    int left = 0;
    int right = n-1;
    while(left <= right){
        int mid = left + (right - left)/2;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] < target){
            left = mid+1;
        }
        else {
            right = mid-1;
        }
    }
    return -1;
}

public void main(String[] args){
    int[] nums = {-1,0,3,5,9,12};
    int target = 9;
    int result = binarySearch(nums, target);
    System.out.println(result);
}