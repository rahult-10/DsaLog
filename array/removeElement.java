public int removeElement(int[] nums, int val) {
    int n = nums.length;
    int i = 0;
    for(int j = 0; j < n ; j++){
        if(nums[j] != val){
            nums[i] = nums[j];
            i++;
        }
    }
    return i;
}
//OR
public int remove(int[] nums, int val){
    int left = 0;
    int right = nums.length;
    while(left < right){
        if(nums[left] == val){
            nums[left] = nums[right-1];
            right--;
        }
        else{
            left++;
        }
    }
    return right;
}

public void main(String[] args) {
    int[] nums = {3,2,2,3};
    int val = 3;
    // System.out.println(removeElement(nums, val));
    System.out.println(remove(nums, val));

}