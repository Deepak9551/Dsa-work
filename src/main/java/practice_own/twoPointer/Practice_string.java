package practice_own.twoPointer;

import java.util.Arrays;

public class Practice_string {
    public static void main(String[] args) {
//        frequencyArray("Java");
//        frequencyArray("Python");
//        System.out.println(isomorphics("egg", "add"));
//        System.out.println(isomorphics("java", "java"));
//        System.out.println(isomorphics("ab", "aa"));
//        System.out.println(isomorphics("foo", "bar"));
//        System.out.println(isomorphics("paper", "title"));

//        String[] arr = {"0100","0200","0300","0400","0500","00723"};
//        maxStringFinder(arr);

        compress("aabcccccaaa");

        char[] chr = {'a','b','c','c','c','c','c','a','a','a'};
        System.out.println(compress(chr));

    }

    public static void frequencyArray(String str){
        int[] freq = new int[255];
        char[] chr = str.toCharArray();
        for (int idx : chr) {
            freq[idx] += 1;
        }
        for (char c : chr) {
            int frequency = freq[c];
            System.out.println( c + " - " + frequency);
        }
    }

    public static boolean isomorphics(String s1 , String s2){
        if(s1.length() != s2.length()){
            System.out.println("Not Isomorphic");
            return false;
        }
        int[] freq = new int[255];
        char[] chr1 = s1.toCharArray();
        char[] chr2 = s2.toCharArray();
        for (int i = 0; i < chr1.length; i++) {
            int idx = chr1[i];
            if(freq[idx] ==0){
                freq[idx] = chr2[i];
            } else if (freq[idx] != chr2[i]) {
                System.out.println("Not Isomorphic");
                return false;
            }

        }
        Arrays.fill(freq, 0);
        for (int i = 0; i <chr1.length ; i++) {
            if(freq[chr1[i]]==0){
                return false;
            }
        }
        return true;
    }

    public static void maxStringFinder(String[] arr1 ){
        String max = arr1[0];
        for (int i = 0; i < arr1.length; i++) {
          max =   max(arr1[i],max);
        }

        System.out.println(max);
    }
    public static String max(String max , String s){
        max = purify(max);
        s = purify(s);
        return compare(max, s);
    }

    private static String compare(String a, String b) {
        if(a.length()> b.length()) return a;
        if (a.length()< b.length()) return b;

      String s =   purify(a);
      String t =  purify(b);
        for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i) != t.charAt(i)){
               if(s.charAt(i)> t.charAt(i)){
                   return s;
               }
               else{
                   return t;
               }
           }
        }
      if(a.length()>=b.length()) return  a;
      else return b;
    }

    public static String purify(String s){
//        s = s.substring(0,countZero(s));
//        System.out.println(s);
//        System.out.println(countZero(s));
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!='0') return s.substring(i);
        }
        return s;
    }
//    public static int countZero(String s){
//        int count = 0;
//
//        // duplicate
//int place = 0;
//int pick = 0;
//        for (int i = 0; i < s.length(); i++) {
//          if(s.charAt(i) == '0' && ) count++;
//        }
//        return count;
//    }

    public static  int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(chars);
        if(chars.length==1) return 1;
        for(char ch : chars){
            sb.append(ch);
        }
        String compressed =  compress(sb.toString());
        for (int i = 0; i < compressed.length(); i++) {
            chars[i] = compressed.charAt(i);
        }
        return compressed.length();

    }
    public static String compress(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append(s.charAt(0));
        int low = 0;
        int mid = 1;


        while (mid<s.length()) {
            if (s.charAt(mid) != s.charAt(mid - 1)) {
                if(count>1)  sb.append(count);
                sb.append(s.charAt(mid));

                count = 1;
            } else if (s.charAt(mid) == s.charAt(mid - 1)) {

                count++;
            }
            mid++;

        }
        sb.append(count);
        System.out.println(sb);
        return sb.toString();
    }
    }

