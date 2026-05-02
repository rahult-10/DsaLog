// 1482. Minimum Number of Days to Make m Bouquets
public int bloomDay(int[] bloomDay, int m, int k) {
    long n = bloomDay.length;
    if(n < (long)m*k)
        return -1;
        
    int low = Integer.MAX_VALUE;
    int high = Integer.MIN_VALUE;
    for(int day : bloomDay){
        low = Math.min(low, day);
        high = Math.max(high, day);
    }
    int ans = high;

    while(low <= high){
        int mid = low+(high-low)/2;
        if(possible(bloomDay, mid, m, k)){
            ans = mid;
            high = mid-1;
        }
        else{
            low = mid+1;
        }
    }
    return ans;
}

private boolean possible(int[] bloomDay, int day, int m, int k){
    int n = bloomDay.length;
    int count = 0;
    int noOfBouquet = 0;
    for(int i = 0; i < n; i++){
        if(bloomDay[i] <= day){
            count++;
            if(count == k){
                noOfBouquet++;
                count = 0;
            }
        }
        else{
            count = 0;
        }
    }
    return noOfBouquet >= m;
}

public void main(String[] args) {
    int[] bloomDay = {7,7,7,7,13,11,12,7};
    int m = 2;
    int k = 3;
    int ans = bloomDay(bloomDay, m, k);
    System.out.println(ans);
}