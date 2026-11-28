// LC : 1207. Unique Number of Occurrences
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] freq = new int[2001];

        for (int num : arr) {
            freq[num + 1000]++;
        }

        boolean[] seen = new boolean[1001];

        for (int count : freq) {
            if (count > 0) {
                if (seen[count]) {
                    return false;
                }
                seen[count] = true;
            }
        }

        return true;
    }
}

// OR -> 
class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>(map.values());
        return set.size() == map.size();
    }
}