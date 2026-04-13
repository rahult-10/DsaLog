// Remove Duplicates from Sorted Array
public int removeDuplicates(int[] nums) {
    int n = nums.length;
    int i = 0;
    for(int j = 0; j < n; j++){
        if(nums[j] != nums[i]){
            nums[i] = nums[j];
            i++; 
        }
    }
    return i+1;
}

public void main(String[] args) {
    int[] nums = {1,1,2};
    int result = removeDuplicates(nums);
    System.err.println(result);
}