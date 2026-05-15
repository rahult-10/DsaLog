public int[] intersectionArray(int[] nums1, int[] nums2) {
    HashSet<Integer> set = new HashSet<>();
    HashSet<Integer> result = new HashSet<>();
    for(int i = 0; i < nums1.length; i++){
        set.add(nums1[i]);
    }
    for(int j = 0; j < nums2.length; j++){
        if(set.contains(nums2[j])){
            result.add(nums2[j]);
        }
    }
    int [] output = new int[result.size()];
    int i = 0;
    for(int num : result){
        output[i++] = num;
    }
    return output;
}

public void main(String[] args){
    int[] nums1 = {1,2,2,1};
    int[] nums2 = {2,2};
    int[] result = intersectionArray(nums1, nums2);
    System.out.println(Arrays.toString(result));
}