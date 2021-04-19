package main;

import lfsr.utils.LFSR;
import rc4.RC4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        List<Integer> positions = new ArrayList<>();
        positions.add(24);
        positions.add(23);
        positions.add(22);
        positions.add(17);

        LFSR lfsr = new LFSR("0100001001010010010101001",positions);
        System.out.println(lfsr.generate(100));
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("Time passed: " + elapsedTime);

        List<String> key = new ArrayList<>();
        key.add("1");
        key.add("1");
        key.add("0");
        key.add("0");
        key.add("0");
        key.add("0");
        key.add("0");
        key.add("1");
        key.add("0");
        key.add("1");
        key.add("0");
        key.add("0");
        key.add("1");
        key.add("1");
        key.add("0");
        RC4 rc4 = new RC4(key);
        System.out.println(rc4.generate(45));


    }
}
