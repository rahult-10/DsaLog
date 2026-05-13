public boolean containsDuplicate2(int[] nums, int k) {
    int n = nums.length;
    for(int i = 0; i < n; i++){
        for(int j = i+1; j <= i+k && j < n; j++){
            if(nums[i] == nums[j])
                return true;
        }
    }
    return false;
}

public void main(String[] args){
    int[] nums = {1,2,3,1};
    int k = 3;
    boolean result = containsDuplicate2(nums,k);
    System.out.println(result);
}