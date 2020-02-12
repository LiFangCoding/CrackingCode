package _01_ArraysAndStrings;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class _2_check_permuation {
    /**
     *  We should understand if the permutation comparison is case sensitive.
     *  That is: is God a permutation of dog? Additionally, we should ask if whitespace is significant.
     *  We will assume for this problem that the comparison is case sensitive and whitespace is significant.
     *  So, "god " is different from "dog".
     */

    /**
     * If two strings are permutations, then we know they have the same characters, but in different orders.
     * Therefore, sorting the strings will put the characters from two permutations in the same order.
     * We just need to compare the sorted versions of the strings.
     */
    boolean permutation_sort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return sort(s).equals(sort(t));
    }

    String sort(String s) {
        char[] schars = s.toCharArray();
        Arrays.sort(schars);
        return new String(schars);
    }

    //Note the assumption on line 6. In your interview, you should always check with your interviewer about the
    //size of the character set. We assumed that the character set was ASCII.
    boolean permutation_sort_checkCount(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        //Assumption
        int[] letters = new int[256];
        char[] s_array = s.toCharArray();
        for (char c : s_array) {
            letters[c]++;
        }

        char[] t_array = t.toCharArray();
        for (char c : t_array) {
            letters[c]--;
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
