package oktava.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SudokuVariable implements Variable {

    /**
     * The number written on this position or 0 if this position is free
     */
    int value = 0;

    /**
     * List of numbers that have to be distinct from this one
     */
    List<SudokuVariable> neighbors = new ArrayList<SudokuVariable>();

    @Override
    public boolean pickNextValue() {
        // TODO
        // try all possible remaining numbers, one by one:
        //   if no neighbor has this number, set it and return true
        //   otherwise try another number
        // if each remaining number is used by a neighbor, return false
    }

    @Override
    public boolean isFree() {
        // TODO
        // free variables have value set to zero
    }

    @Override
    public int getValue() {
        // TODO
    }

    @Override
    public void setValue(int value) {
        // TODO
    }
}
