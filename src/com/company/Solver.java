package com.company;

//Solver: Contains static methods for solving the grid, implementing the brute force algorithm. It
//        would also be helpful to keep a tally of the number of operations used to solve the puzzle.
public class Solver {

    // static iteration counter
    public static int iteration = 0;

    // constructor takes in the grid and calls solution methods on it
    public Solver(Grid grid) {
        // create a solution
        if(solveSudoku(grid)) {
            // print solution
            printMatrix(grid);
        } else { /* else no solution can be found */
            System.out.println("No solution found");
        }
        // reset iteration number for next use
        iteration = 0;
    }

    // utility method to print solution
    public static void printMatrix(Grid grid) {
        System.out.println("SOLUTION: " + "\n");
        // iterate through matrix rows
        for (int i = 0; i < grid.matrix.length; i++) {
            // iterate through matrix columns
            for (int j = 0; j < grid.matrix[i].length; j++) {
                // print value of cell
                System.out.print(grid.matrix[i][j].getValue() + " ");
            }
            // after row printed, print a newline character to start the next row
            System.out.println();
        }
        System.out.println("Recursive calls: " + iteration);
    }

    // recursive method to solve sudoku
    public static boolean solveSudoku(Grid grid) {
        // initialise i, j counting variables
        int i = -1, j = -1;
        // while increments i each iteration whilst checking if its greater then a length of a sudoku board
        while (++i < 9) {
            // condition checks if j has gone out of bounds
            if (j > grid.matrix[i].length - 1)
                j = -1; /* if so set j to -1 so it can iterate through the next row of board */
            // while increments j each iteration
            while (++j < 9) {
                // condition check if value of matrix[i][j] is 0
                if (grid.matrix[i][j].getValue() == 0) {
                    // if so create a for loop to test digits 1-9 in empty space
                    for (int digit = 1; digit <= 9; digit++) {
                        // set matrix[i][j] equal to digit
                        grid.matrix[i][j].setValue(digit);
                        // test if this cell currently works in the sudoku
                        if (!grid.isDuplicate(grid.matrix[i][j])) {
                            // increment iteration
                            ++iteration;
                            // test if solveSudoku is true calls itself again
                            if (solveSudoku(grid)) {
                                // if so return true
                                return true;
                            }
                            // else set matrix[i][j] to 0 which will cause method to backtrack when this cell is
                            // encountered in next call
                            grid.matrix[i][j].setValue(0);
                        }
                        // if it is a duplicate set matrix[i][j] to 0
                        grid.matrix[i][j].setValue(0);
                    }
                    // if no digit can be found return false no solution found
                    return false;
                }
            }
        }
        // if while loop is fully executed without returning false then a solution has been found return true
        return true;
    }
}

