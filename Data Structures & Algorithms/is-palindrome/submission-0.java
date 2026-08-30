class Solution {

    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            // Non-alphanumeric character skip
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            else {

                // Lowercase karke compare
                if (Character.toLowerCase(s.charAt(i)) !=
                    Character.toLowerCase(s.charAt(j))) {

                    return false;
                }

                i++;
                j--;
            }
        }

        return true;
    }
}