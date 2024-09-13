import java.util.Random;

/*  Student information for assignment:
 *
 *  UTEID: sst2284
 *  email address: sohumtrip@gmail.com
 *  Grader name: Karnika C
 *  Number of slip days I am using: 1
 */



/* CS314 Students. Put your experiment results and
 * answers to questions here.
 */

/**
 * A class to run tests on the MathMatrix class
 */
public class MathMatrixTester {

    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {
        int[][] data1 = { {1, 2, 3},
                {2, 3, 4}};
        int[][] data2 = { {2, 1, 1},
                {2, 3, 1}};
        int[][] e1;

        //test 1, specify size and values constructor
        MathMatrix mat1 = new MathMatrix(2, 2, -1);
        e1 = new int[][] {{-1, -1}, {-1, -1}};
        printTestResult( get2DArray(mat1), e1, 1,
                "Constructor with size and initial val specified.");

        MathMatrix ma2 = new MathMatrix(2, 2, 1);
        e1 = new int[][] {{1,1}, {1,1}};
        printTestResult( get2DArray(ma2), e1, 2,"Constructor with size and initial val specified.");

        //tests 2 and 3, int[][] constructor, deep copy
        mat1 = new MathMatrix( data1 );
        data1[0][0] = 2;
        // alter data1. mat1 should be unchanged if deep copy made
        e1 = new int[][] { {2, 2, 3}, {2, 3, 4} };
        printTestResult( data1, e1, 2, "constructor with one parameter of type int[][]");
        // data1 altered. mat1 should be unchanged if deep copy made
        e1 = new int[][] { {1, 2, 3}, {2, 3, 4} };
        printTestResult( get2DArray(mat1), e1, 3,
                "constructor with one parameter of type int[][]. Testing deep copy made.");

        //test 5, get val
        data1=new int[][]{{0,0},{1,1}};
        mat1 = new MathMatrix(data1);
        if(mat1.getVal(0,0)==0){
            System.out.println("passed test 5, get val method.");
        } else{

            System.out.println("failed test 5, addition method.");
        }
        //test 6, get val
        data1=new int[][]{{1,1},{0,0}};
        mat1 = new MathMatrix(data1);
        if(mat1.getVal(0,1)==1){
            System.out.println("passed test 6, get val method.");
        } else{

            System.out.println("failed test 6, addition method.");
        }
        //test 7, addition
        data1=new int[][]{{0,1},{2,3}};
        data2=new int[][]{{4,5},{6,7}};
        mat1 = new MathMatrix(data1);
        MathMatrix mat2 = new MathMatrix(data2);
        MathMatrix mat3 = mat1.add(mat2);
        e1 = new int[][] { {4, 6}, {8, 10} };
        MathMatrix mat4 = new MathMatrix(e1);
        if(mat3==mat4){
            System.out.println("passed test 7, addition method.");
        } else{
            System.out.println("failed test 7, addition method.");
        }

        //test 8, addition
        data1=new int[][]{{0,0},{0,0}};
        data2=new int[][]{{0,0},{0,0}};
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        mat3 = mat1.add(mat2);
        e1 = new int[][] { {0, 0}, {0, 0} };
        mat4 = new MathMatrix(e1);
        if(mat3==mat4){
            System.out.println("passed test 8, addition method.");
        } else{
            System.out.println("failed test 8, addition method.");
        }

        //test 9, subtraction
        data1=new int[][]{{1,1},{1,1}};
        data2=new int[][]{{0,0},{0,0}};
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        mat3 = mat1.subtract(mat2);
        e1 = new int[][] { {1, 1}, {1, 1} };
        mat4 = new MathMatrix(e1);
        if(mat3==mat4){
            System.out.println("passed test 9, subtraction method.");
        } else{
            System.out.println("failed test 9, subtraction method.");
        }

        //test 10, subtraction
        data1=new int[][]{{1,2},{1,1}};
        data2=new int[][]{{0,2},{0,0}};
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        mat3 = mat1.subtract(mat2);
        e1 = new int[][] { {1, 0}, {1, 1} };
        mat4 = new MathMatrix(e1);
        if(mat3==mat4){
            System.out.println("passed test 10, subtraction method.");
        } else{
            System.out.println("failed test 10, subtraction method.");
        }
       
       
        //test 11, multiplication
        data1 = new int[][] { {5, 6}, {7, 8}};
        data2 = new int[][] { {1, 2}, {3, 4}};
        mat2 = new MathMatrix(data2);
        mat1 = new MathMatrix(data1);
        mat3 = mat2.multiply(mat1);
        e1 = new int[][] { {19,22}, {43,50} };
        printTestResult( get2DArray(mat3), e1, 11, "multiply method");
         
        //test 12, multiplication
        data1 = new int[][] { {7, 8}, {9, 10},{11,12}};
        data2 = new int[][] { {1, 2,3}, {4, 5,6}};
        mat2 = new MathMatrix(data2);
        mat1 = new MathMatrix(data1);
        mat3 = mat2.multiply(mat1);
        e1 = new int[][] { {58,64}, {139,154} };
        printTestResult( get2DArray(mat3), e1, 12, "multiply method");
//test 13, scale
        data1=new int[][]{{1,1},{1,1}};
        mat1=new MathMatrix(data1);
        mat2=mat1.getScaledMatrix(2);
        e1=new int[][]{{2,2},{2,2}};
        mat3=new MathMatrix(e1);
        if(mat2==mat3){
            System.out.println("passed test 13, scale method.");
        } else{
            System.out.println("failed test 13, scale  method.");
        }
//test 14, scale
        data1=new int[][]{{3,3},{3,3}};
        mat1=new MathMatrix(data1);
        mat2=mat1.getScaledMatrix(3);
        e1=new int[][]{{9,9},{9,9}};
        mat3=new MathMatrix(e1);
        if(mat2==mat3){
            System.out.println("passed test 14, scale method.");
        } else{
            System.out.println("failed test 14, scale  method.");
        }
        //test 15, transpose
        
        data1= new int[][]{{1,2,3 },{3,4, 5}};
        mat1=new MathMatrix(data1);
        e1 = new int[][] {{1,3},{2,4},{3,5} };
        mat2=mat1.getTranspose();
        mat3=new MathMatrix(e1);
        if(mat2==mat3){
            System.out.println("passed test 15, transpose method.");
        } else{
            System.out.println("failed test 15, transpose method.");
        }
        
        //test 16, transpose
        data1= new int[][]{{1,2},{0,3}};
        mat1=new MathMatrix(data1);
        e1 = new int[][] { {1,0}, {2,3} };
        mat2=mat1.getTranspose();
        mat3=new MathMatrix(e1);
        if(mat2==mat3){
            System.out.println("passed test 16, transpose method.");
        } else{
            System.out.println("failed test 16, transpose method.");
        }
        //test 17, equals
        data1= new int[][]{{1,2},{3,4}};
        data2=new int[][]{{1,2},{3,4}};
        mat1=new MathMatrix(data1);
        mat2=new MathMatrix(data2);
        if(mat1.equals(mat2)){
            System.out.println("passed test 17, equals method.");
        } else{
            System.out.println("failed test 17, equals method.");
        }
        //test 18, equals
        data1= new int[][]{{0,2},{3,4}};
        data2=new int[][]{{1,2},{3,5}};
        mat1=new MathMatrix(data1);
        mat2=new MathMatrix(data2);
        if(mat1.equals(mat2)){
            System.out.println("failed test 18, equals method.");
        } else{
            System.out.println("passed test 18, equals method.");
        }
        //test 19, toString
        data1 = new int[][] {{11, 102, 103, -1004},
            {1005, 16, 57, 8},
            {9, -1, 2, 3}};
            mat1 = new MathMatrix(data1);
            String expected = "|    11   102   103 -1004|\n|" +
                    "  1005    16    57     8|\n|     9    -1     2     3|\n";
            if (mat1.toString().equals( expected )) {
                System.out.println("passed test 19, toString method.");
            } else {
                System.out.println("failed test 19, toString method.");
            }

            //test 20, toString
            data1 = new int[][] {{19, 108, 107, -1006},
            {1005, 14, 53, 2},
            {1, -9, 8, 7}};
            mat1 = new MathMatrix(data1);
            String expected2 = "|    19   108   107 -1006|\n|" +
                    "  1005    14    53     2|\n|     1    -9     8     7|\n";
            if (mat1.toString().equals( expected2 )) {
                System.out.println("passed test 20, toString method.");
            } else {
                System.out.println("failed test 20, toString method.");
            }

            //test 21, upperTriangular
            data1 = new int[][] {{1,2},{0,3}};
            mat1 = new MathMatrix(data1);
            if (mat1.isUpperTriangular()) {
                System.out.println("Passed test 21, upperTriangular method.");
            } else {
                System.out.println("Failed test 21, upperTriangular method.");
            }

            //test 22, upperTriangular
            data1 = new int[][] {{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 0, 4, -1}, {1, 22, 30, 4}};
            mat1 = new MathMatrix(data1);
            if (!mat1.isUpperTriangular()) {
                System.out.println("Passed test 22, upperTriangular method.");
            } else {
                System.out.println("Failed test 21, upperTriangular method.");   
            }


           
            // CS314 Students. When ready delete the above tests 
            // and add your 22 tests here.


    }

    // method that sums elements of mat, may overflow int!
    // pre: mat != null
    private static int sumVals(MathMatrix mat) {
        if (mat == null) {
            throw new IllegalArgumentException("mat may not be null");
        } 
        int result = 0;
        final int ROWS =  mat.getNumRows();
        final int COLS = mat.getNumColumns();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                result += mat.getVal(r, c); // likely to overflow, but can still do simple check
            }
        }
        return result;
    }

    // create a matrix with random values
    // pre: rows > 0, cols > 0, randNumGen != null
    public static MathMatrix createMat(Random randNumGen, int rows,
            int cols, final int LIMIT) {

        if (randNumGen == null) {
            throw new IllegalArgumentException("randomNumGen variable may no be null");
        } else if(rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("rows and columns must be greater than 0. " +
                    "rows: " + rows + ", cols: " + cols);
        }

        int[][] temp = new int[rows][cols];
        final int SUB = LIMIT / 4;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;
            }
        }

        return new MathMatrix(temp);
    }

    private static void printTestResult(int[][] data1, int[][] data2, int testNum, 
            String testingWhat) {
        System.out.print("Test number " + testNum + " tests the " + testingWhat +". The test ");
        String result = equals(data1, data2) ? "passed" : "failed";
        System.out.println(result);
    }

    // pre: m != null, m is at least 1 by 1 in size
    // return a 2d array of ints the same size as m and with 
    // the same elements
    private static int[][] get2DArray(MathMatrix m) {
        //check precondition
        if  ((m == null) || (m.getNumRows() == 0) 
                || (m.getNumColumns() == 0)) {
            throw new IllegalArgumentException("Violation of precondition: get2DArray");
        }

        int[][] result = new int[m.getNumRows()][m.getNumColumns()];
        for(int r = 0; r < result.length; r++) {
            for(int c = 0; c < result[0].length; c++) {
                result[r][c] = m.getVal(r,c);
            }
        }
        return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2) {
        //check precondition
        if((data1 == null) || (data1.length == 0) 
                || (data1[0].length == 0) || !rectangularMatrix(data1)
                ||  (data2 == null) || (data2.length == 0)
                || (data2[0].length == 0) || !rectangularMatrix(data2)) {
            throw new IllegalArgumentException( "Violation of precondition: " + 
                    "equals check on 2d arrays of ints");
        }
        boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
        int row = 0;
        while (result && row < data1.length) {
            int col = 0;
            while (result && col < data1[0].length) {
                result = (data1[row][col] == data2[row][col]);
                col++;
            }
            row++;
        }

        return result;
    }


    // method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix( int[][] mat ) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null" 
                    + " and must be at least 1 by 1");
        }
        return MathMatrix.rectangularMatrix(mat);
    }
}
