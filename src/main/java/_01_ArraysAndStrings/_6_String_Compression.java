package _01_ArraysAndStrings;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class _6_String_Compression {
    public String compress(String str) {
        StringBuilder compressed = new StringBuilder();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;

            /**
             * !!! i is the last one
             */
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 0;
            }
        }

        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}
