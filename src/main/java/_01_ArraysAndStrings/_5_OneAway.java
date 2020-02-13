package _01_ArraysAndStrings;

/**
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * <p>
 * EXAMPLE
 * pale, ple true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bae -> false
 */
public class _5_OneAway {
    public boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }

        return false;
    }

    private boolean oneEditReplace(String first, String second) {
        int countDiff = 0;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                countDiff++;
            }

            if (countDiff >= 2) {
                return false;
            }
        }

        return true;
    }

    private boolean oneEditInsert(String s1, String s2) {
        int idx1 = 0;
        int idx2 = 0;

        int countDiff = 0;
        while (idx2 < s2.length() && idx1 < s1.length()) {
            if (s1.charAt(idx1) != s2.charAt(idx2)) {
                countDiff++;
                idx2++;
                if (countDiff >= 2) {
                    return false;
                }
            } else {
                idx1++;
                idx2++;
            }
        }

        return true;
    }

}
