package _01_ArraysAndStrings;

/**
 * rite a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: if implementing in Java, please use a character array so that you can perform this operation in place.
 *
 * EXAMPLE
 * Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"
 */
public class _3_URLIfy {
    /**
     * A common approach in string manipulation problems is to edit the string starting from the end and working backwards.
     * This is useful because we have an extra buffer at the end,
     * which allows us to change characters without worrying about what we're overwriting.
     */
    public void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        int index;

        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        index = trueLength + spaceCount * 2;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                index--;
                str[index] = str[i];
            }
        }
    }

    public static void main(String[] args) {
        _3_URLIfy test = new _3_URLIfy();
        char[] str = "Mr John Smith     ".toCharArray();
        test.replaceSpaces(str, 13);
        System.out.println(new String(str));
    }
}
