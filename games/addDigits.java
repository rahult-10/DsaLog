public int addDigits(int num) {
    return 1 + (num-1)%9;
}

public void main(String[] args){
    int num = 5238;
    int result = addDigits(num);
    System.out.println(result);
}