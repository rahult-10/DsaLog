public boolean happyNumber(int n){
    int slow = square(n);
    int fast = square(square(n));
    while(slow != fast){
        slow = square(slow);
        fast = square(square(fast));
        if(slow == 1 || fast == 1){
            return true;
        }
    }
    return slow == 1;
}

public int square(int n){
    int ans = 0;
    while(n > 0){
        int ld = n%10;  // ld -> last digit
        ans += ld * ld;
        n /= 10;
    }
    return ans;
}

public void main() {
    int n = 19;
    boolean result = happyNumber(n);
    System.out.println(result);
}