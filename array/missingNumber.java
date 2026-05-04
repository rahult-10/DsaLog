public int missingNumber(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for(int i = 0; i<n; i++){
        sum+=nums[i];
    }
    int actualSum = n*(n+1)/2;
    int missingSum = actualSum - sum;

    return missingSum;
}

public void main(String[] args){
    int[] nums ={3,0,1};
    int result = missingNumber(nums);
    System.out.println(result);
}
    