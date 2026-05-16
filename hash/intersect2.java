public int[] intersect2(int[] nums1, int[] nums2) {
    List<Integer> list = new ArrayList<>();
    for(int i = 0; i < nums1.length; i++){
        for(int j = 0; j < nums2.length; j++){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                nums2[j] = -1;
                break;
            }
        }
    }
    int[] result = new int[list.size()];
    for(int i = 0; i < list.size(); i++){
        result[i] = list.get(i);
    }
    return result;
}

public void main(String[] args){
    int[] nums1 = {1,2,2,1};
    int[] nums2 = {2,2};
    int[] result = intersect2(nums1,nums2);
    System.out.println(Arrays.toString(result));
}