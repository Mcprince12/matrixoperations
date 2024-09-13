import java.util.Arrays;

// MathMatrix.java - CS314 Assignment 2

/*  Student information for assignment:
*
*  On my honor, Sohum Tripathi, this programming assignment is my own work
*  and I have not provided this code to any other student.
*
*  UTEID: sst2284
*  email address: sohumtrip@gmail.com
*  Unique section number: 50220
*  Number of slip days I am using: 1
*/

/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 */
public class MathMatrix {

    // instance variable
    private int matrix[][];

    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * 
     * @param mat mat !=null, mat.length > 0, mat[0].length > 0,
     *            mat is a rectangular matrix
     */
    public MathMatrix(int mat[][]) {
        // Initialize your new math matrix

        // Loop through the mat
        matrix = new int[mat.length][mat[0].length];
        // check preconditions
        if (mat != null && mat.length > 0 && mat[0].length > 0) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = mat[i][j];
                }
            }
        }

    }

    /**
     * create a MathMatrix of the specified size with all cells set to the
     * intialValue.
     * <br>
     * pre: numRows > 0, numCols > 0
     * <br>
     * post: create a matrix with numRows rows and numCols columns.
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal
     * for all valid r and c.
     * 
     * @param numRows    numRows > 0
     * @param numCols    numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal) {
        matrix = new int[numRows][numCols];
        if (numRows > 0 && numCols > 0) {
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    matrix[i][j] = initialVal;
                }
            }
        }

    }

    /**
     * Get the number of rows.
     * 
     * @return the number of rows in this MathMatrix
     */
    public int getNumRows() {
        return matrix.length;
    }

    /**
     * Get the number of columns.
     * 
     * @return the number of columns in this MathMatrix
     */
    public int getNumColumns() {
        return matrix[0].length;
    }

    /**
     * get the value of a cell in this MathMatrix.
     * <br>
     * pre: row 0 <= row < getNumRows(), col 0 <= col < getNumColumns()
     * 
     * @param row 0 <= row < getNumRows()
     * @param col 0 <= col < getNumColumns()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {
        int selectedVal = 0;
        if (row >= 0 && row < getNumRows()) {
            if (col >= 0 && col < getNumColumns()) {
                selectedVal = matrix[row][col];
            }
        }
        return selectedVal;
    }

    /**
     * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
     * <br>
     * pre: rightHandSide != null, rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.getNumColumns() = getNumColumns()
     * <br>
     * post: This method does not alter the calling object or rightHandSide
     * 
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(),
     *                      rightHandSide.getNumColumns() = getNumColumns()
     * @return a new MathMatrix that is the result of adding this Matrix to
     *         rightHandSide.
     *         The number of rows in the returned Matrix is equal to the number of
     *         rows in this MathMatrix.
     *         The number of columns in the returned Matrix is equal to the number
     *         of columns
     *         in this MathMatrix.
     */
    public MathMatrix add(MathMatrix rightHandSide) {
        MathMatrix newMatrix = new MathMatrix(matrix);
        if (rightHandSide.getNumRows() == getNumRows() && rightHandSide.getNumColumns() == getNumColumns()) {
            for (int i = 0; i < getNumRows(); i++) {
                for (int j = 0; j < getNumColumns(); j++) {
                    newMatrix.matrix[i][j] = getVal(i, j) + rightHandSide.getVal(i, j);
                }
            }
        }
        return newMatrix;
    }

    /**
     * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
     * <br>
     * pre: rightHandSide != null, rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.getNumColumns() = getNumColumns()
     * <br>
     * post: This method does not alter the calling object or rightHandSide
     * 
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(),
     *                      rightHandSide.getNumColumns() = getNumColumns()
     * @return a new MathMatrix that is the result of subtracting rightHandSide
     *         from this MathMatrix. The number of rows in the returned MathMatrix
     *         is equal to the number
     *         of rows in this MathMatrix.The number of columns in the returned
     *         MathMatrix is equal to
     *         the number of columns in this MathMatrix.
     */
    public MathMatrix subtract(MathMatrix rightHandSide) {
        MathMatrix newMatrix = new MathMatrix(matrix);
        if (rightHandSide.getNumRows() == getNumRows() && rightHandSide.getNumColumns() == getNumColumns()) {
            for (int i = 0; i < getNumRows(); i++) {
                for (int j = 0; j < getNumColumns(); j++) {
                    newMatrix.matrix[i][j] = getVal(i, j) - rightHandSide.getVal(i, j);
                }
            }
        }
        return newMatrix;
    }

    /**
     * implements matrix multiplication, (this MathMatrix) * rightHandSide.
     * <br>
     * pre: rightHandSide != null, rightHandSide.getNumRows() = getNumColumns()
     * <br>
     * post: This method should not alter the calling object or rightHandSide
     * 
     * @param rightHandSide rightHandSide.getNumRows() = getNumColumns()
     * @return a new MathMatrix that is the result of multiplying
     *         this MathMatrix and rightHandSide.
     *         The number of rows in the returned MathMatrix is equal to the number
     *         of rows
     *         in this MathMatrix. The number of columns in the returned MathMatrix
     *         is equal to the number
     *         of columns in rightHandSide.
     */
    public MathMatrix multiply(MathMatrix rightHandSide) {
        // check preconditions
        MathMatrix newMatrix = new MathMatrix(getNumRows(), rightHandSide.getNumColumns(), 0);
        if (rightHandSide != null && rightHandSide.getNumRows() == getNumColumns()) {
            for (int i = 0; i < getNumRows(); i++) {
                for (int j = 0; j < rightHandSide.getNumColumns(); j++) {
                    for (int k = 0; k < getNumColumns(); k++) {

                        newMatrix.matrix[i][j] += getVal(i, k) * rightHandSide.getVal(k, j);
                    }
                }
            }
        }

        return newMatrix;
    }

    /**
     * Create and return a new Matrix that is a copy
     * of this matrix, but with all values multiplied by a scale
     * value.
     * <br>
     * pre: none
     * <br>
     * post: returns a new Matrix with all elements in this matrix
     * multiplied by factor.
     * In other words after this method has been called
     * returned_matrix.getVal(r,c) = original_matrix.getVal(r, c) * factor
     * for all valid r and c.
     * 
     * @param factor the value to multiply every cell in this Matrix by.
     * @return a MathMatrix that is a copy of this MathMatrix, but with all
     *         values in the result multiplied by factor.
     */
    public MathMatrix getScaledMatrix(int factor) {
        MathMatrix newMatrix = new MathMatrix(matrix);
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                newMatrix.matrix[i][j] = getVal(i, j) * factor;
            }
        }
        return newMatrix;
    }

    /**
     * accessor: get a transpose of this MathMatrix.
     * This Matrix is not changed.
     * <br>
     * pre: none
     * 
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose() {
        MathMatrix newMatrix = new MathMatrix(matrix);
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                newMatrix.matrix[i][j] = getVal(j, i);
            }
        }
        return newMatrix;
    }

    /**
     * override equals.
     * 
     * @return true if rightHandSide is the same size as this MathMatrix and all
     *         values in the
     *         two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide) {
        /*
         * CS314 Students. The following is standard equals
         * method code. We will learn about in the coming weeks.
         *
         * We use getClass instead of instanceof because we only want a MathMatrix to
         * equal
         * another MathMatrix as opposed to any possible sub classes. We would
         * use instance of if we were implementing am interface and wanted to equal
         * other objects that are instances of that interface but not necessarily
         * MathMatrix objects.
         */

        if (rightHandSide == null || this.getClass() != rightHandSide.getClass()) {
            return false;
        }
        // We know rightHandSide refers to a non-null MathMatrix object, safe to cast.
        MathMatrix otherMathMatrix = (MathMatrix) rightHandSide;
        int counter = 0;
        int sameCounter = 0;
        for (int i = 0; i < otherMathMatrix.getNumRows(); i++) {
            for (int j = 0; j < otherMathMatrix.getNumColumns(); j++) {
                if (otherMathMatrix.getVal(i, j) == getVal(i, j)) {
                    sameCounter++;
                }
                counter++;
            }
        }
        // checking sameness
        if (counter != sameCounter) {
            return false;
        }
        // Now we can access the private instance variables of otherMathMatrix
        // and / or call MathMatrix methods on otherMathMatrix.

        return true; // CS314 students, alter as necessary
    }

    /**
     * override toString.
     * 
     * @return a String with all elements of this MathMatrix.
     *         Each row is on a separate line.
     *         Spacing based on longest element in this Matrix.
     */
    // helper method to find longest element in the matrix
    public static int maxStringLength(int[][] arr) {
        int max = 0;
        for (int[] row : arr) {
            for (int element : row) {
                int lengthOfInt = String.valueOf(element).length();
                if (lengthOfInt > max) {
                    max = lengthOfInt;
                }
            }
        }
        return max;
    }

    public String toString() {
        int max = maxStringLength(matrix);
        MathMatrix newMatrix = new MathMatrix(matrix);

        String str = "";
        for (int i = 0; i < getNumRows(); i++) {
            str += "|";
            for (int j = 0; j < getNumColumns(); j++) {
                // adding element and space after
                str += String.format("%" + (max + 1) + "s", newMatrix.matrix[i][j]);
            }
            // new line for each subsequent row
            str += "|\n";
        }
        return str;
    }

    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main
     * diagonal must be 0.<br>
     * pre: this is a square matrix. getNumRows() == getNumColumns()
     * 
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     *         <tt>false</tt> otherwise.
     */
    public boolean isUpperTriangular() {
        MathMatrix newMatrix = new MathMatrix(matrix);
        if (getNumRows() == getNumColumns()) {
            // start from 2nd row so initialize i as 1
            for (int i = 1; i < getNumRows(); i++) {
                // checking elements below diagonal
                for (int j = 0; j < i; j++) {
                    if (newMatrix.matrix[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Ensure mat is a rectangular matrix. Method is public so
     * client classes can also use it.
     * 
     * @param mat mat != null, mat must have at least one row,
     *            there must be at least one column in the first row, and
     *            all rows in mat must have the same number of columns.
     * @return true if mat is rectangular, false otherwise.
     */
    public static boolean rectangularMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("argument mat may not be null and must "
                    + " have at least one row. mat = " + Arrays.toString(mat));
        } else if (mat[0] == null) {
            throw new IllegalArgumentException("argument may not have null rows. "
                    + "mat = " + Arrays.toString(mat));
        } else if (mat[0].length == 0) {
            throw new IllegalArgumentException("argument mat must have at least "
                    + "one column per row.");
        }
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;
        while (isRectangular && row < mat.length) {
            // Odd to put this here. Maybe do a two pass approach?
            if (mat[row] == null) {
                throw new IllegalArgumentException("argument may not have null rows. "
                        + "mat = " + Arrays.toString(mat));
            }
            isRectangular = (mat[row].length == COLUMNS);
            row++;
        }
        return isRectangular;
    }

}