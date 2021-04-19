package rc4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RC4 {
    private State initialState;
    private List<String> key;
    private int[] S0;

    public RC4() {

    }

    private int[] identityPerm(){
        int[] perm = new int[257];
        for(int i=0;i<=255;i++){
            perm[i]=i;
        }
        return perm;
    }

    private void prepareInitialState(){
        int j=0;
        S0 = identityPerm();

        for(int i=0;i<=255;i++){
            j=(j + S0[i] + Integer.parseInt((key.get(i % key.size())))) % 255;
            int aux = S0[i];
            S0[i] =S0[j];
            S0[j] = aux;
        }
        initialState.setI(0);
        initialState.setJ(0);
        initialState.setS(S0);
    }
    public String generate(int n) {
        prepareInitialState();
        int nCounter = 0;
        StringBuilder returned = new StringBuilder();
        while(nCounter < n){
            int i = initialState.getI() + 1;
            int j = (initialState.getJ() + initialState.getS()[i])%256;

            int aux = initialState.getS()[i];
            initialState.getS()[i] = initialState.getS()[j];
            initialState.getS()[j] = aux;
            returned.append(initialState.getS()[(initialState.getS()[i] + initialState.getS()[j]) % 256]);
            initialState.setI(i);
            initialState.setJ(j);
            nCounter++;
        }
        return returned.toString();


    }

    public RC4(List<String> key) {
        this.key = key;
        initialState = new State();
    }
}
