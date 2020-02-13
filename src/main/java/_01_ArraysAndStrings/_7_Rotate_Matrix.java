package _01_ArraysAndStrings;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class _7_Rotate_Matrix {
    //TODO: need more think
    public boolean rotate(int[][] m) {
        if (m.length == 0 || m.length != m[0].length) {
            return false;
        }

        int n = m.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = m[first][i];

                // left -> top
                m[first][i] = m[last - offset][first];

                // bottom -> left
                m[last - offset][first] = m[last][last - offset];

                //right -> bottom
                m[last][last - offset] = m[i][last];

                //top -> right
                m[i][last] = top;
            }
        }

        return true;
    }
}
