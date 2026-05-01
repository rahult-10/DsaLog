// Ugly number 2
public int UglyNumber2(int n) {
    TreeSet<Long> uglySet = new TreeSet<>();
    uglySet.add(1L);
    Long currentUgly = 1L;

    for(int i = 0; i < n; i++){
        currentUgly = uglySet.pollFirst();

        uglySet.add(currentUgly * 2);
        uglySet.add(currentUgly * 3);
        uglySet.add(currentUgly * 5);

    }

    return currentUgly.intValue();
}

public void main(String[] args) {
    int n = 12;
    int ans = UglyNumber2(n);
    System.out.println(ans);
}