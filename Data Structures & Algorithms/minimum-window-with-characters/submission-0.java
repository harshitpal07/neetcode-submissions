class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] freq = new int[128]; 
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }
        int low = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length();
        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);
            if (freq[ch] > 0) {
                count--;
            }
            freq[ch]--;
            while (count == 0) {
                if (high - low + 1 < minLen) {
                    minLen = high - low + 1;
                    start = low;
                }
                char left = s.charAt(low);
                freq[left]++;
                if (freq[left] > 0) {
                    count++;
                }
                low++;
            }
        }
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}