package lfsr.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static int xor(int nr1, int nr2) {
        return (nr1+nr2) % 2;

    }
    public static List<String> leftShift(String text) {
        List<String> list = new ArrayList<>();
        String firstChar = Character.toString(text.charAt(0));
        text = text.substring(1);
        list.add(text);
        list.add(firstChar);
        return list;
    }
    public static String f(String key,List<Integer> positions,List<Integer> c){
        int cIndex = 1;
        int current= Integer.parseInt(Character.toString(key.charAt(positions.get(0))))*c.get(0);
        List<Integer> localPositions = positions.subList(1,positions.size());
        for(Integer position: localPositions){
            current = xor(current,Integer.parseInt(Character.toString(key.charAt(position)))*c.get(cIndex));
        }
        return Integer.toString(current);
    }
}
