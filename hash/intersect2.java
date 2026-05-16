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


public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for(int num1 : nums1){
        map.put(num1, map.getOrDefault(num1,0)+1);
    }

    List<Integer> list = new ArrayList<>();

        for(int num2 : nums2){
        if(map.containsKey(num2) && map.get(num2) > 0){
            list.add(num2);
            map.put(num2, map.get(num2)-1);
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

    int[] res = intersect(nums1, nums2);
    
    System.out.println(Arrays.toString(result));
    System.out.println(Arrays.toString(result));
}