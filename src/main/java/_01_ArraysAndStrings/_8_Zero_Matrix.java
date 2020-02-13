package _01_ArraysAndStrings;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
public class _8_Zero_Matrix {
    /**
     * O(MN)
     * O(N) space
     */
    public void setZeros(int[][] m) {
        // row length
        int len1 = m.length;
        // col length
        int len2 = m[0].length;

        boolean[] row = new boolean[len1];
        boolean[] col = new boolean[len2];


        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (m[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < len1; i++) {
            if (row[i]) {
                for (int j = 0; j < len2; j++) {
                    m[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < len2; j++) {
            if (col[j]) {
                for (int i = 0; i < len1; i++) {
                    m[i][j] = 0;
                }
            }
        }
    }

    //TODO: need to be careful
    public void setZeros_SaveSpace(int[][] m) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        int len1 = m.length;
        int len2 = m[0].length;

        // check if first row has zero
        for (int j = 0; j < len2; j++) {
            if (m[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < len1; i++) {
            if (m[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (m[i][j] == 0) {
                    m[i][0] = 0;
                    m[0][j] = 0;
                }
            }
        }

        for (int j = 1; j < len2; j++) {
            if (m[0][j] == 0) {
                for (int i = 1; i < len1; i++) {
                    m[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < len1; i++) {
            if (m[i][0] == 0) {
                for (int j = 1; j < len2; j++) {
                    m[i][j] = 0;
                }
            }
        }

        if (rowHasZero) {
            for (int j = 0; j < len2; j++) {
                m[0][j] = 0;
            }
        }

        if (colHasZero) {
            for (int i = 0; i < len1; i++) {
                m[i][0] = 0;
            }
        }
    }
}
