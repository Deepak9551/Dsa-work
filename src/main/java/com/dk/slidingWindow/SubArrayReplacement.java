package com.dk.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArrayReplacement {
    public static void main(String[] args) {
//        findMaxFrequency("abcabbb");
        longestCharacterWithSameLetterReplacement("ABAB",2);
    }

    public static int findMaxFrequency(String s){

        int[] arr = new int[255];
        for (int i = 0; i < s.length(); i++) {
            int ch  = s.charAt(i); // 97
            arr[ch]++;
        }
int max  = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
        max = Math.max(max,arr[i]);
        }
        System.out.println(max);
        return max;
    }
    public static void longestCharacterWithSameLetterReplacement(String s  , int k){
        int low = 0;
        Map<Character , Integer > map = new HashMap<>();
        int res = 0;
        for (int high = 0; high < s.length(); high++) {


            // information (SUM) mai high ko include karo
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0) + 1);
    int totalCharacter = high - low + 1;
    int majority = findMaxFrequency(s);
    int diff = totalCharacter - majority;

    while (diff<k){
        char l = s.charAt(low);
        map.put(l,map.get(l) - 1);

        if(map.get(l) == 0){
            map.remove(l);
        }
        low++;
        totalCharacter = high - low + 1;
        majority = findMaxFrequency(s);
        diff = totalCharacter - majority;
    }
    int len = high - low + 1;
    res = Math.max(res,len);
            System.out.println(res);
        }
    }
}
