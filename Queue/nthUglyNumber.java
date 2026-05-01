public int nthUglyNumber(int n) {
    PriorityQueue<Long> minHeap = new PriorityQueue<>();
    Set<Long> seenNumber = new HashSet<>();
    int[] primeFactors = {2, 3, 5};

    minHeap.offer(1L);
    seenNumber.add(1L);
    long currentUgly = 1L;

    for(int i = 0; i < n; i++){
        currentUgly = minHeap.poll();

        for (int prime : primeFactors) {
            long nextUgly = currentUgly * prime;
            if (seenNumber.add(nextUgly)) {
                minHeap.offer(nextUgly);
            }
        }
    }

    return (int) currentUgly;
}

public void main(String[] args){
    int n = 10;
    int ans = nthUglyNumber(n);
    System.out.println(ans);
}