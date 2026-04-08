package practice_own.twoPointer.Pw.Arrays;

import java.util.Arrays;

public class CompressedString {
    public static void main(String[] args) {



        char[] chr = {'a','b','c','c','c','c','c','a','a','a'};
       compressed2pointer(chr);
    }
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

    public static void compressed2pointer(char [] chars){
        int i = 0;
        int n = chars.length;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (j<n) {
            if (chars[i] == chars[j]) {
                j++;
            } else {
                sb.append(chars[i]);
                int len = j - i;
                if (len > 0) sb.append(len);
                i = j; // j point to the unique element
            }
        }
            sb.append(chars[i]);
            int len = j - i;
            if(len >0) sb.append(len);
            for (int k = 0; k <sb.length(); k++) {
                chars[k] = sb.charAt(k);
            }
        System.out.println(sb);
        System.out.println(sb.length());
    }
}
