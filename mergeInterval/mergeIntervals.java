public int[][] mergeIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
    int n = intervals.length;
    int[][] result = new int[n][2];
    result[0] = intervals[0];
    int e = 0;
    for(int i = 1; i < n; i++){
        if(intervals[i][0] <= result[e][1]){
            result[e][1] = Math.max(result[e][1], intervals[i][1]);
        }
        else {
            e++;
            result[e] = intervals[i];
        }
    }
    return Arrays.copyOfRange(result, 0, e+1);
}

public void main(String[] args) {
    int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
    int[][] answer = mergeIntervals(intervals);
    for (int[] interval : answer) {
        System.out.println(interval[0] + " " + interval[1]);
    }
}