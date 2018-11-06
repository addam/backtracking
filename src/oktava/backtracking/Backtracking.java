package oktava.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Backtracking {
    public List<Variable> variables = new ArrayList<Variable>();


    public boolean solve() {
        Stack<Variable> assigned = new Stack<Variable>();
        while (!isDone()) {
            Variable position = pickVariable();
            if (position != null) {
                assigned.push(position);
            } else {
                while (!assigned.peek().pickNextValue()) {
                    assigned.pop();
                    if (assigned.empty()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isDone() {
        for (Variable position : variables) {
            if (position.isFree()) {
                return false;
            }
        }
        return true;
    }

    private Variable pickVariable() {
        for (Variable position : variables) {
            if (position.isFree()) {
                if (position.pickNextValue()) {
                    return position;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

}
