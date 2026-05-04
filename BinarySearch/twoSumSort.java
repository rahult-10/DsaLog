
public int[] twoSumSort(int[] numbers, int target) {
    int n = numbers.length;

    for (int i = 0; i < n; i++) {
        int complement = target - numbers[i];

        int left = i + 1;
        int right = n - 1;

        // Binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == complement) {
                return new int[]{i + 1, mid + 1}; // 1-based index
            } else if (numbers[mid] < complement) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    return new int[]{-1, -1};
}

public void main(String[] args){
    int numbers[] = {2,7,11,15};
    int target = 9;
    int[] result = twoSumSort(numbers, target);
    System.out.println(Arrays.toString(result));
}
