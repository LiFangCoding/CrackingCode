package _01_ArraysAndStrings;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 */
public class _1_IsUnique {
    /**
     * O(n)
     * @param s
     * @return
     */
    public boolean isUniqueChars_set(String s) {
        if (s == null) {
            return true;
        }

        boolean[] char_set = new boolean[256];

        for (char c : s.toCharArray()) {
            if (char_set[c]) {
                return false;
            }
            char_set[c] = true;
        }

        return true;
    }

    /**
     * If string is only a-z
     * only 26. Can use integer to bit vector
     */

    public boolean isUniqueChars_bit_vector(String s) {
        int checker = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }

        return true;
    }
}
