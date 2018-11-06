package oktava.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SudokuVariable implements Variable {
    int value = 0;
    List<SudokuVariable> neighbors = new ArrayList<SudokuVariable>();

    @Override
    public boolean pickNextValue() {
        for (int i = value + 1; i <= 9; i++) {
            boolean canAssignThis = true;
            for (SudokuVariable other : neighbors) {
                if (other.value == i) {
                    canAssignThis = false;
                }
            }
            if (canAssignThis) {
                value = i;
                return true;
            }
        }
        value = 0;
        return false;
    }

    @Override
    public boolean isFree() {
        return (value == 0);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }
}
