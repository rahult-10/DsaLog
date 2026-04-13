public void mergeSortArray(int[] nums1, int m, int[] nums2, int n) {
    int [] mn = new int[m+n];
    int i=0;
    int j=0;
    int k=0;
    while(i < m && j < n){
        if(nums1[i] < nums2[j]){
            mn[k++] = nums1[i++];
        }
        else {
            mn[k++] = nums2[j++];
        }
    }
    while(i < m){
        mn[k++] = nums1[i++];
    }
    while(j < n){
        mn[k++] = nums2[j++];
    }
    for(i = 0; i< m+n; i++){
        nums1[i] = mn[i];
    }
}

public void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    int m = 3;
    int n = nums2.length;
    mergeSortArray(nums1, m, nums2, n);

    for (int num : nums1) {
        System.out.print(num + " ");
    }
}