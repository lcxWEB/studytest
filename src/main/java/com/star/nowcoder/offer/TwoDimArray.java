package com.star.nowcoder.offer;

/**
 * @Author: lcx
 * @Date: 2019/2/28 20:58
 * @Description:
 */

public class TwoDimArray {

    public boolean Find(int target, int [][] array) {
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{0,2,3},{6,7,8}};
        System.out.println(new TwoDimArray().Find(1, array));
    }

}
