public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] nge = new int[n];
    for (int i = 0; i < n; i++) {
        nge[i] = -1;
        for (int j=1; j < n; j++) {
            int idx = (i+j)%n;
            if(nums[idx] > nums[i]){
                nge[i] = nums[idx];
                break;
            }
        }
    }
    return nge;
}

public void main(String[] args) {
    int[] nums= {1,2,3,4,3};
    int[] res = nextGreaterElements(nums);
    System.out.println(Arrays.toString(res));
}