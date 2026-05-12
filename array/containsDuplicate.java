public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for(int num : nums){
        if(set.contains(num)){
            return true;
        }
        set.add(num);
    }
    return false;
}

public boolean containDuplicate(int[] nums) {
    Arrays.sort(nums);
    for(int i = 1; i < nums.length; i++){
        if(nums[i] == nums[i-1]){
            return true;
        }
    }
    return false;
}


public void main(String[] args){
    int[] nums = {1,2,3,1};
    boolean result = containsDuplicate(nums);
    boolean res = containDuplicate(nums);
    System.out.println(result + "," + res);
}