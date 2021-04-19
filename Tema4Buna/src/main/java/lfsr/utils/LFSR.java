package lfsr.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LFSR {
    String initialState;
    List<Integer> positions;
    List<Integer> c;

    public LFSR(String initialState, List<Integer> positions) {
        Random rand = new Random();
        this.initialState = initialState;
        this.positions = positions;
        this.c = new ArrayList<>();
        c.add(1);
        for(Integer position: positions){
            c.add(rand.nextInt(2));
        }
    }

    public String generate(int size){
        int sizeCounter=0;
        StringBuilder bitReturned = new StringBuilder();
        while(sizeCounter<size){
            StringBuilder stringBuilder =new StringBuilder();

            stringBuilder.append(initialState);
            String newBit = Utils.f(initialState,positions,c);
            stringBuilder.append(newBit);
            bitReturned.append(stringBuilder.toString().charAt(0));
            stringBuilder.delete(0,1);
            initialState = stringBuilder.toString();
            sizeCounter++;
        }

        return bitReturned.toString();
    }


}
