//LC 3. Longest Substring Without Repeating Characters
// Longest Substring with Distinct Characters
public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();

    int left = 0;
    int maxLength = 0;

    for (int right = 0; right < s.length(); right++) {

        // Remove duplicate characters
        while (set.contains(s.charAt(right))) {
            set.remove(s.charAt(left));
            left++;
        }

        // Add current character
        set.add(s.charAt(right));

        // Update maximum length
        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}

/* Let's understand with an example
Input: s = "abcabc"
Iteration 1: right = 0, character = 'a'
Is 'a' already in Set? No.
Skip while loop.
Add 'a' to Set.
Set = {a}

Iteration 2: right = 1, character = 'b'
Is 'b' already in Set? No.
Skip while loop.
Add 'b' to Set.
Set = {a, b}

Iteration 3: right = 2, character = 'c'
Is 'c' already in Set? No.
Skip while loop.
Add 'c' to Set.
Set = {a, b, c}

Iteration 4: right = 3, character = 'a'
Now the interesting part!
Is 'a' already in Set? Yes!
Remove s.charAt(left) → removes 'a'.
Increment left from 0 to 1.
Is 'a' still in Set? No.
Exit while loop.
Add current 'a' to Set.
Set = {b, c, a}
*/