package com.star.nowcoder.offer;

public class ReplaceWhitespace {

    public static String replaceSpace(StringBuffer str) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append('%').append('2').append('0');
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("wewew ddfd");
        System.out.println(replaceSpace(sb));
        System.out.println(frontCompWithZore(18000, 4));
    }



    public static String frontCompWithZore(int sourceDate, int formatLength) {
        String newString = String.format("%0" + formatLength + "d", sourceDate);
        return newString;
    }
}
