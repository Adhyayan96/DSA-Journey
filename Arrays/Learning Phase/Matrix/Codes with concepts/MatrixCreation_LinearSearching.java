import java.util.*;
public class MatrixCreation_LinearSearching {

    // search a key element, in the matrix : Linear search in a matrix
    public static boolean LinearSearching(int matrix[][], int key){
        for(int row = 0; row<matrix.length; row++){
            for(int col = 0; col<matrix[0].length; col++){
                if(matrix[row][col]==key){ // Linear search
                    return true;
                }
            }
        }
        return false;
    }


    // make a matrix & print it
    public static void main(String[] args){
        int matrix[][] = new int[3][3]; // creation : rows & columns -->> 3*3 = 9 cells in the matrix
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();

        // taking inputs
        for(int row = 0; row<matrix.length; row++){ // row numbers
            for(int col = 0; col<matrix[0].length; col++){ // for each row, i'm taking that row's all col's values

                /* for finding length of column : write matrix[0].length -->> it will give the length of first column.
                   And if you get to know first col's length, then other column's length will be same too.
                */
                matrix[row][col] = sc.nextInt();
            }
        }

        // print the matrix
        for(int row = 0; row<matrix.length; row++){
            for(int col = 0; col<matrix[0].length; col++){
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

        System.out.println(LinearSearching(matrix, key));
        sc.close();
    }
}
