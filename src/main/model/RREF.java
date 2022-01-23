package main.model;

public class RREF {

    public double[][] Rref(double[][] matrix){
        int lead = 0;
        int i;

        // number of rows and columns in matrix
        int numRows = matrix.length;
        int numColumns = matrix[0].length;

        for(int k = 0; k < numRows; k++){
            if(numColumns <= lead){
                break;
            }
            i = k;
            while(matrix[i][lead] == 0){
                i++;
                if(numRows == i){
                    i = k;
                    lead++;
                    if(numColumns == lead){
                        break;
                    }
                }

            }
            matrix = rowSwap(matrix, i, k);
            if(matrix[k][lead] != 0){
                matrix = rowScale(matrix, k, (1/matrix[k][lead]));
            }
            for(i = 0; i < numRows; i++){
                if(i != k){
                    matrix = rowAddScale(matrix, k, i,((-1) * matrix[i][lead]));
                }
            }
            lead++;
        }

        return matrix;
    }

    //MODIFIES: this
    //EFFECTS: swaps position of two rows
    public double[][] rowSwap(double[][] matrix, int rowIndex1,
                                      int rowIndex2){
        // number of columns in matrix
        int numColumns = matrix[0].length;

        // holds number to be swapped
        double hold;

        for(int k = 0; k < numColumns; k++){
            hold = matrix[rowIndex2][k];
            matrix[rowIndex2][k] = matrix[rowIndex1][k];
            matrix[rowIndex1][k] = hold;
        }

        return matrix;
    }

    //MODIFIES: this
    //EFFECTS: adds two rows together
    public double[][] rowAdd(double[][] matrix, int rowIndex1,
                                     int rowIndex2){
        // number of columns in matrix
        int numColumns = matrix[0].length;

        for(int k = 0; k < numColumns; k++){
            matrix[rowIndex2][k] += matrix[rowIndex1][k];
        }

        return matrix;
    }

    //MODIFIES: this
    //EFFECTS: multiplies row by a scalar
    public double[][] rowScale(double[][] matrix, int rowIndex,
                                       double scalar){
        // number of columns in matrix
        int numColumns = matrix[0].length;

        for(int k = 0; k < numColumns; k++){
            matrix[rowIndex][k] *= scalar;
        }

        return matrix;
    }

    //MODIFIES: this
    //EFFECTS: adds row by another row * scalar
    public double[][] rowAddScale(double[][] matrix, int rowIndex1,
                                          int rowIndex2, double scalar){
        // number of columns in matrix
        int numColumns = matrix[0].length;

        for(int k = 0; k < numColumns; k++){
            matrix[rowIndex2][k] += (matrix[rowIndex1][k] * scalar);
        }

        return matrix;
    }
}
