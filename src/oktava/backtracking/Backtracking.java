package oktava.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Backtracking {
    public List<Variable> variables = new ArrayList<Variable>();

    private Variable pickVariable() {
        // TODO
        // find a free variable
        // note: you don't have to use this function in your code
    }

    private boolean isDone() {
        // TODO
        // sudoku is done if all variables are assigned
        // note: you don't have to use this function in your code
    }

    /**
     * Try and solve the given constrained problem
     * @return whether a solution was found
     */
    public boolean solve() {
        // TODO
        // maintain a LIFO stack of assigned variables throughout this function
        // pick a free variable. If there are no free variables, the whole sudoku is solved!
        // let the variable to pick a new value
        //   if it found no more options, we need to unassign it and repeat with the variable assigned previously
        //   if we had to repeat the previous step so many times that no variables are assigned, the sudoku has no solution.
    }

}
