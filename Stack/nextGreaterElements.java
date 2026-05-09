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


public int[] ngElement(int[] nums){
    int n = nums.length;
    int[] nge = new int[n];
    Arrays.fill(nge, -1);

    Stack<Integer> st = new Stack<>();
    for (int i = 2 * n - 1; i >= 0; i--) {
        int idx = i % n;

        while (!st.isEmpty() && nums[st.peek()] <= nums[idx]) {
            st.pop();
        }

        if (i < n) {
            if (!st.isEmpty()) {
                nge[idx] = nums[st.peek()];
            }
        }

        st.push(idx);
    }

    return nge;
}

public int[] nextGreatElements(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    int[] st = new int[n];
    Arrays.fill(res,-1);
    int top = -1;
    for(int i = 0; i < 2*n; i++){
        int num = nums[i%n];
        while(top >= 0 && nums[st[top]] < num){
            res[st[top--]] = num;
        }
        if(i < n){
            st[++top] = i;
        }
    }
    return res;
}

public void main(String[] args) {
    int[] nums= {1,2,3,4,3};
    int[] res = nextGreaterElements(nums);
    int[] result = ngElement(nums);
    System.out.println(Arrays.toString(res) + "  " + Arrays.toString(result));
}