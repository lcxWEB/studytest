package com.star;

/**
 * @Author: lcx
 * @Date: 2019/2/12 11:34
 * @Description:
 */

public class BigDecimalTest {

    public static void main(String[] args) {
        // BigDecimal bigDecimal = new BigDecimal(100.77);
        // BigDecimal other = new BigDecimal(3.01);
        // BigDecimal result = bigDecimal.divide(other, BigDecimal.ROUND_HALF_UP);
        // int scale = result.scale();
        // System.out.println(scale);
        // System.out.println(result);
        // System.out.println(bigDecimal);

        // boolean[] booleans = new boolean[10];
        // for (int i = 0; i < booleans.length; i++) {
        //     System.out.println(booleans[i]);
        // }

        String[] strings = new String[10];
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "abc" + i;
        }

        for (int i = 0; i < strings.length; i++) {
            result = result + strings[i];
        }
        System.out.println(result);

        StringBuilder stringBuilder = new StringBuilder(10);
        stringBuilder.append("[");
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i]).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]");
        System.out.println(stringBuilder);
        Integer a = 1000;
        int b = 1000;

        System.out.println(a == b);

        Integer m = 1;
        Integer n = 2;
        Long k = 3L;
        System.out.println(k == (m + n));
        System.out.println(k.equals(m + n));

    }

}
