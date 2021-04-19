package rc4;

import java.util.ArrayList;
import java.util.List;

public class State {
    private int i;
    private int j;
    private int[] S;

    public State() {

    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int[] getS() {
        return S;
    }

    public void setS(int[] s) {
        S = s;
    }
}
