package com.dk.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubStringKDistinct {
    public static void main(String[] args) {

        String s = "aabacbebebe";
//        substringKdistinctElement(s,3);
//        longestSubArrayWithAtMost(new int[]{1,2,1},2);
        longestSubArrayWithNoRepeat("pwwkew",3);
    }

    public static void substringKdistinctElement(String s,int k){

        Map<Character,Integer> map = new HashMap<>();

        int low  = 0;
        int maxlen = 0;

        for (int high = 0; high < s.length(); high++) {

            // move right point
            // information mai hight ko include karo
            char c = s.charAt(high);
            map.put(c,map.getOrDefault(c,0) + 1);

            while (map.size()>k){
                char ch = s.charAt(low);
                map.put(ch, map.get(ch) - 1);

                if(map.get(ch)==0){
                    map.remove(ch);
                }
                low++;
            }


            if (map.size() == k) {
                maxlen = Math.max(maxlen,high - low + 1);
            }
        }

        System.out.println(maxlen);
    }

    public static void longestSubArrayWithAtMost(int[] s , int k){

        // patter = sliding ( longest subArray )
        // fixed
        int low = 0;


        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for (int high = 0; high < s.length; high++) {

            // information (SUM) mai high ko include karo
            int ch = s[high];
           map.put(ch,map.getOrDefault(ch,0) + 1);

            // jaab taak information wrong hai
            // information correct karo ->
            // low ++ , low ko answer mai se remove karo
            while (map.size()>k){
               int l = s[low];
               map.put(l,map.get(l) - 1);

               if(map.get(l) == 0){
                   map.remove(l);
               }
               low++;
            }

            int len = high - low + 1;
            res = Math.max(res,len);

        }
        System.out.println(res);
    }

    public static void longestSubArrayWithNoRepeat(String s , int k){

        // patter = sliding ( longest subArray )
        // variable
        int low = 0;


        int res = 0;
        Map<Character,Integer> map = new HashMap<>();

        for (int high = 0; high < s.length(); high++) {

            // information (SUM) mai high ko include karo
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0) + 1);

            k  = high - low + 1;
            // jaab taak information wrong hai
            // information correct karo ->
            // low ++ , low ko answer mai se remove karo
            while (map.size()<k){
                char l = s.charAt(low);
                map.put(l,map.get(l) - 1);

                if(map.get(l) == 0){
                    map.remove(l);
                }
                low++;
                k = high - low + 1;
            }


            if (map.size() == k) {
                res = Math.max(res,k);
            }

        }
        System.out.println(res);
    }
}
