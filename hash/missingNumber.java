public int missingNumber(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int num : nums)
        map.put(num,1);
    for(int i = 0; i <= nums.length; i++){
        if(!map.containsKey(i)){
            return i;
        }
    }
    return -1;
}

public void main(String[] args) {
    int[] nums = {3,0,1,4,5};
    int result = missingNumber(nums);
    System.out.println(result);
}
