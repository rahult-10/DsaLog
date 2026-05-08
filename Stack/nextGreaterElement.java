public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] nge = new int[nums1.length];
    for(int i = 0; i< nums1.length; i++){
        int index = -1;
        for(int j = 0; j < nums2.length; j++){
            if(nums2[j] == nums1[i]){
                index = j;
                break;
            }
        }
        nge[i] = -1;
        for(int j = index+1; j < nums2.length; j++){
        if(nums2[j] > nums1[i]){
                nge[i] = nums2[j];
                break;
            }
        }
    }
    return nge;
}

//Optimized -> Using Stack, HashMap
public int[] ngElement(int[] nums1, int[] nums2){
    Map<Integer, Integer> map = new HashMap<>();
    Deque<Integer> stack = new ArrayDeque<>();

    for(int num : nums2){
        while(!stack.isEmpty() && num > stack.peek()){
            map.put(stack.pop(), num);
        }
        stack.push(num);
    }
    while(!stack.isEmpty()){
        map.put(stack.pop(), -1);
    }
    int[] result = new int[nums1.length];
    for(int i = 0; i < nums1.length; i++){
        result[i] = map.get(nums1[i]);
    }
    return result;
}


public void main(String[] args) {
    int nums1[] = {4,1,2};
    int nums2[] = {1,3,4,2};
    int[] res = nextGreaterElement(nums1, nums2);
    System.out.println(Arrays.toString(res));
    int[] ans = ngElement(nums1, nums2);
    System.out.println(Arrays.toString(ans));
}