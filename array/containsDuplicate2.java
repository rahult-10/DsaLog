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

public boolean containsNearbyDuplicate(int[] nums, int k) {
    int n = nums.length;
    HashSet<Integer> set = new HashSet<>();
    for(int i = 0; i < n; i++){
        if(i > k){
            set.remove(nums[i-k-1]);
        }

        if(set.contains(nums[i])){
            return true;
        }
        set.add(nums[i]);
    }
    return false;
}

public void main(String[] args){
    int[] nums = {1,2,3,1};
    int k = 3;
    boolean result = containsDuplicate2(nums,k);
    boolean res = containsNearbyDuplicate(nums, k);
    System.out.println(result + "," + res);
}