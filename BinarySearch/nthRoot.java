// You are given 2 numbers n and m, the task is to find n√m (nth root of m). If the root is not integer then return -1.


public int nthRoot(int n, int m) {
    // code here
    if(m == 0){
        return 0;
    }
    int low = 1;
    int high = m;
    while(low <= high){
        int mid = low + (high-low)/2;
        if(Math.pow(mid,n)==m){
            return mid;
        }
        else if(Math.pow(mid,n)< m){
            low = mid+1;
        }
        else {
            high = mid-1;
        }
    }
    return -1;
}


public void main(String args[]){
    int n = 3;
    int m  = 8;
    int result = nthRoot(n,m);
    System.out.println(result);
}