public boolean nimGame(int n) {
    return n%4 != 0;
}

public void main(String[] args) {
    int n = 4;
    boolean result = nimGame(n);
    System.out.println(result);
}