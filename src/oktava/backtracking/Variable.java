package oktava.backtracking;

public interface Variable {
    boolean isFree();
    int getValue();
    void setValue(int i);
    boolean pickNextValue();
}
