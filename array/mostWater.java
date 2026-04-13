// 11. Container With Most Water
/*Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array 
[1,8,6,2,5,4,8,3,7]. In this case, the max area of water 
(blue section) the container can contain is 49. */



public static int maxWater(int[] height) {
    int lp = 0;
    int rp = height.length-1;
    int maxWater = 0;
    while(lp < rp){
        int lh = height[lp];
        int rh = height[rp];
        int currWater = Math.min(lh, rh) * (rp - lp);
        maxWater = Math.max(currWater, maxWater);

        //Move the smaller height pointer

        if (lh < rh) {
            while (lp < rp && height[lp] <= lh) lp++;
        } else {
            while (lp < rp && height[rp] <= rh) rp--;
        }
        
       //OR 
        // if(lh < rh)
        //     lp++;
        // else 
        //     rp--;
    }
    return maxWater;
}

public static void main(String[] args) {
    int [] height = {1,8,6,2,5,4,8,3,7};
    int result = maxWater(height);
    System.out.println(result);
}