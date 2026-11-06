// gfg -> Minimum Distance in Array
public int minDist(int[] arr,int x, int y){
    int lastX = -1;
    int lastY = -1;
    int ans = Integer.MAX_VALUE;
    for(int i = 0; i < arr.length; i++){
        if(arr[i] == x){
            lastX = i;
            if(lastY != -1){
                ans = Math.min(ans, Math.abs(lastX - lastY));
            }
        }

        if(arr[i] == y){
            lastY = i;
            if(lastX != -1){
                ans = Math.min(ans, Math.abs(lastX - lastY));
            }
        }
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
}