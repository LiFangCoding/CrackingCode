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
    public boolean isUniqueChars(String s) {
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

}
