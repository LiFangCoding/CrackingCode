package _01_ArraysAndStrings;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 *
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat'; "atc o eta·; etc.)
 */
public class _4_Palindrom_Permutation {
    /**
     * We use a hash table to count how many times each character appears.
     * Then, we iterate through the hash table and ensure that no more than one character has an odd count.
     */
    public boolean isPermutationOfPalindrome_hashCount(String phrase) {
        int[] table = new int[26];

        for (char c : phrase.toCharArray()) {
            table[c - 'a']++;
        }

        int oddCount = 0;
        for (int count : table) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }

    /**
     * 'a' -> 'z' can  can map to 0 - 26.
     * When we see a letter, we map it to an integer between O and 26 (assuming an English alphabet).
     * Then we toggle the bit at that value.
     * At the end of the iteration, we check that at most one bit in the integer is set to 1.
     */
    public boolean isPermuationOfPalindrome(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = c - 'a';
            int mask = 1 << x;
            if ((bitVector & mask) == 0) {
                bitVector |= mask;
            } else {
                bitVector &= ~mask;
            }
        }

        return (bitVector == 0) || ((bitVector & (bitVector - 1)) == 0);
    }
}
