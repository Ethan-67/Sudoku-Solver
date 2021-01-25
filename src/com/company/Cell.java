package com.company;

//Cell: The cells of a playing grid. You may want to give the cell a boolean property for whether it
//        can be edited or not. Cells that are in the original puzzle definition wouldn’t be editable.
public class Cell {

    // stores if cell can be edited or not
    private boolean editable;
    // stores value of cell
    private int value;
    // stores x position of cell
    private int x;
    // stores y position of cell
    private int y;

    // constructor initialises instance variables
    public Cell(int value, int x, int y, boolean editable) {
        // init editable
        this.editable = editable;
        // init value
        this.value = value;
        // init x
        this.x = x;
        // init y
        this.y = y;
    }

    // override to string method used to print out instance variables of an individual Cell
    @Override
    public String toString() {
        return new String("Edit: " + editable + " value: " + value + " x: " + x + " y: " + y);
    }

    // x coord getter
    public int getX() {
        return x;
    }

    // y coord getter
    public int getY() {
        return y;
    }

    // value getter
    public int getValue() {
        return value;
    }

    // editable getter
    public boolean isEditable() {
        return editable;
    }

    // x coord setter
    public void setX(int x) {
        this.x = x;
    }

    // y coord setter
    public void setY(int y) {
        this.y = y;
    }

    // value setter
    public void setValue(int value) {
        this.value = value;
    }

    // editable setter
    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}
