package com.company;

//Grid: The collection of cells arranged across a 2d array.
//         You will want methods for getting and setting the value of cells.
//         You will also want methods for determining if there is a duplicated value
//        across rows, columns or an inner 3 by 3 grid.
//        You will also want a method for displaying the grid to the console, perhaps overriding the toString method.
public class Grid {

    // stores grid of cells
    Cell matrix[][];

    // constructor initialises matrix with cells
    public Grid(int[][] intMatrix) {
        // initialise matrix
        matrix = new Cell[intMatrix.length][intMatrix[0].length];
        // iterate through matrix arr rows
        for (int i = 0; i < intMatrix.length; i++) {
            // iterate through matrix arr cols
            for (int j = 0; j < intMatrix[0].length; j++) {
                // declare Cell variable interface
                Cell plot;
                // condition checks if int matrix value at [i][j] is 0
                if (intMatrix[i][j] == 0) {
                    // if so create a cell with a editable status
                    plot = new Cell(intMatrix[i][j], j, i, true);
                } else {
                    // else create a cell that is not editable
                    plot = new Cell(intMatrix[i][j], j, i, false);
                }
                // set [i][j] to be equal to the cell created
                matrix[i][j] = plot;
            }
        }
    }

    // method checks if @param Cell is allowed to be in the sudoku solution
    public boolean isDuplicate(Cell current) {
        // condition checks if current is 0, in which case does not need to be checked (sudoku ranges 1-9)
        if (current.getValue() == 0)
            return false;
        // three methods to check if there is a duplicate for current in the row, column or subsquare, return true if so
        if (isDuplicateSquare(current) || isDuplicateRow(current) || isDuplicateColumn(current))
            return true;
        // otherwise return false
        return false;
    }

    // check is there is a duplicate in row
    private boolean isDuplicateRow(Cell current) {
        // iterate through matrix rows, uses current y value to find position in row initialises i to this value
        for (int j = 0, i = current.getY(); j < matrix[0].length; j++) {
            // if matrix[i][j] and current share the same value and j is not equal to current x (case where it would
            // fall under itself in condition)
            if (current.getValue() == matrix[i][j].getValue() && j != current.getX()) {
                // then duplicate found return true
                return true;
            }
        }
        // return false if no match is found indicating row is clear to insert the current cell's value
        return false;
    }

    // check if there is a duplicate in column
    private boolean isDuplicateColumn(Cell current) {
        // iterate through matrix column, uses current x value to find position in column and initialise j to this value
        for (int i = 0, j = current.getX(); i < matrix.length; i++) {
            // if current and matrix[i][j] share same value and i is not equal to current y (case where it would
            // fall under itself in condition)
            if (current.getValue() == matrix[i][j].getValue() && i != current.getY()) {
                // then duplicate found return true
                return true;
            }
        }
        // return false if no match is found indicating column is clear to insert the current cell's value
        return false;
    }

    // finds if there is a duplicate in sudoku 3x3 square
    private boolean isDuplicateSquare(Cell current) {
        // initialise x range variables
        int startX = 0, endX = 0;
        // if current x is or between 0-2
        if (current.getX() >= 0 && current.getX() <= 2) {
            // initialise startX to lower bound range and endX to upper bound range
            startX = 0;
            endX = 2;
        } else if (current.getX() >= 3 && current.getX() <= 5) { /* if current x is or between 3-5 */
            // initialise startX to lower bound range and endX to upper bound range
            startX = 3;
            endX = 5;
        } else if (current.getX() >= 6 && current.getX() <= 8) { /* if current x is or between 6-8 */
            // initialise startX to lower bound range and endX to upper bound range
            startX = 6;
            endX = 8;
        }

        // initialise y range variables
        int startY = 0, endY = 0;
        // if current y is or between 0-2
        if (current.getY() >= 0 && current.getY() <= 2) {
            // initialise startY to lower bound range and endY to upper bound range
            startY = 0;
            endY = 2;
        } else if (current.getY() >= 3 && current.getY() <= 5) { /* if current y is or between 3-5  */
            // initialise startY to lower bound range and endY to upper bound range
            startY = 3;
            endY = 5;
        } else if (current.getY() >= 6 && current.getY() <= 8) { /* if current y is or between 6-8  */
            // initialise startY to lower bound range and endY to upper bound range
            startY = 6;
            endY = 8;
        }

        // iterate from startX to endX
        for (int x = startX; x <= endX; x++) {
            // iterate from startY to endY
            for (int y = startY; y <= endY; y++) {
                // condition checks if in the 3x3 square there is a duplicate value unless both x, y are equal to
                // current x and current y, which would mean it is comparing itself to itself in the matrix
                if (current.getValue() == matrix[y][x].getValue() && (x != current.getX() && y != current.getY())) {
                    // if match found then there is a duplicate in 3x3 square return true
                    return true;
                }
            }
        }
        // no duplicate found then return false
        return false;
    }

    // override toString method, used for printing the initial unsolved matrix
    @Override
    public String toString() {
        // initialise string builder
        StringBuilder matrixStr = new StringBuilder();
        // iterate through matrix rows
        for (int i = 0; i < matrix.length; i++) {
            // iterate through matrix columns
            for (int j = 0; j < matrix[i].length; j++) {
                // append value at matrix[i][j] with a space
                matrixStr.append(matrix[i][j].getValue() + " ");
            }
            // when row finished append a new line character to start the next row
            matrixStr.append("\n");
        }
        // return string builder toString
        return matrixStr.toString();
    }

    // matrix setter
    public void setMatrix(Cell[][] matrix) {
        this.matrix = matrix;
    }

    // matrix getter
    public Cell[][] getMatrix() {
        return matrix;
    }
}