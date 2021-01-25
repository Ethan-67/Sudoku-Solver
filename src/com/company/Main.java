package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Main: Loads a grid in from a file and runs the solver method.
public class Main {
    public static void main(String[] args) {
        // create a int matrix
	    int matrix[][] = new int[9][9];

        try {
            // find file sudoku
            File file = new File("extensionPuzzle.txt");
            // create scanner bound to file
            Scanner scan = new Scanner(file);
            // counter variable
            int i = 0;
            // while scanner has a line
            while (scan.hasNextLine()) {
                // create a row from file
                String[] row = scan.nextLine().split(",");
                // iterate through row
                for (int j = 0; j < row.length; j++) {
                    // input number from String row to int matrix
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
                // increment i
                i++;
            }
        } catch (FileNotFoundException e) { /* file not found exception handling */
            System.out.println(e);
        }

        // create a grid using the int matrix
        Grid grid = new Grid(matrix);
        // print original puzzle
        System.out.println(grid.toString());
        // create a solver to solve the matrix in grid
        Solver solve = new Solver(grid);
    }
}









