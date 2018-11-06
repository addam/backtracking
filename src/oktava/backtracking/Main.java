package oktava.backtracking;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Backtracking solver = emptySudoku();
        solver.variables.get(1).setValue(3);
        if (solver.solve()) {
            dumpSudoku(solver);
        } else {
            System.out.println("No solution");
        }
    }

    public static void dumpSudoku(Backtracking solver) {
        for (int i=0; i < solver.variables.size(); i++) {
            System.out.print(solver.variables.get(i).getValue());
            if (i % 9 == 8) {
                System.out.println();
            } else {
                System.out.print(", ");
            }
        }
    }

    private static Backtracking emptySudoku() {
        Backtracking result = new Backtracking();
        for (int i=0; i < 9*9; i++) {
            result.variables.add(new SudokuVariable());
        }
        ArrayList<ArrayList<Variable>> groups = new ArrayList<ArrayList<Variable>>();
        for (int i=0; i<9; i++) {
            ArrayList<Variable> row = new ArrayList<Variable>();
            ArrayList<Variable> column = new ArrayList<Variable>();
            ArrayList<Variable> block = new ArrayList<Variable>();
            for (int j=0; j<9; j++) {
                row.add(result.variables.get(9 * i + j));
                column.add(result.variables.get(i + 9 * j));
                block.add(result.variables.get(27 * (i / 3) + 9 * (j / 3) + 3 * (i % 3) + (j % 3)));
            }
            groups.add(row);
            groups.add(column);
            groups.add(block);
        }
        for (ArrayList<Variable> group : groups) {
            for (Variable a : group) {
                SudokuVariable sa = (SudokuVariable) a;
                for (Variable b : group) {
                    if (a != b && !sa.neighbors.contains(b))
                    ((SudokuVariable) a).neighbors.add((SudokuVariable) b);
                }
            }
        }
        return result;
    }

    private static int blockIndex(int i) {
        return i % 3 + 9 * (i / 3);
    }
}
