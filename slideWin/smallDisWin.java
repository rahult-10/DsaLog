// gfg -> Smallest Window Length with All
// Smallest Distinct Window
class Solution {
	public int findSubString(String s) {
		// code here
		int[] freq = new int[26];
		
		// Count distinct characters in original string
		int distinct = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (freq[s.charAt(i) - 'a'] == 0) {
				distinct++;
			}
			freq[s.charAt(i) - 'a']++;
		}
		
		// Reset frequency array for sliding window
		freq = new int[26];
		
		int left = 0;
		int count = 0;
		int minLength = s.length();
		
		for (int right = 0; right < s.length(); right++) {
			
			char ch = s.charAt(right);
			
			// Add character to window
			if (freq[ch - 'a'] == 0) {
				count++;
			}
			
			freq[ch - 'a']++;
			
			// Shrink window while it contains all distinct characters
			while (count == distinct) {
				
				minLength = Math.min(minLength, right - left + 1);
				
				char leftChar = s.charAt(left);
				
				freq[leftChar - 'a']--;
				
				if (freq[leftChar - 'a'] == 0) {
					count--;
				}
				
				left++;
			}
		}
		
		return minLength;
	}
}
