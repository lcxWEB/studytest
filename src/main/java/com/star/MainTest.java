package com.star;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lcx on 2018/10/12.
 */


public class MainTest {

    int v;
    final int d = 0;

    public static void main(String[] args) {

//        try {
//            SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
//            UUAgentMapper uuAgentMapper = sqlSession.getMapper(UUAgentMapper.class);
//            int start = 0;//正确的叫法应该是offset
//            int pagesize = 3;//<span style="font-family: 'Microsoft YaHei';">正确的叫法应该是limit</span>
//            RowBounds rowBounds = new RowBounds(start,pagesize);
//            List<UUAgent> re = uuAgentMapper.listAllUUAgent(rowBounds);
//            for(UUAgent ui:re){
//                System.out.println(ui);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        List<String> list = new ArrayList<>();
        String[] arr = {};
        // System.out.println(list.getClass());
        for (String s : arr) {
            System.out.println(s + "=====");
        }

        Integer[] a = new Integer[]{1, 2, 3, 4};
        int sumre = Stream.of(a).reduce(0, Integer::sum);
        System.out.println(sumre);

        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected = collected.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
        System.out.println(collected);

        collected = collected.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));//注意发生的变化
        System.out.println(collected);

        System.out.println((3.14 + 1e20) - 1e20);
        System.out.println(3.14 + (1e20 - 1e20));
        System.out.println(3.14 + 1e20);

        int b;
        final int c;
        final HashSet set = new HashSet();
        set.add("sdsds");
        System.out.println(set.remove("adsds"));
        // set = new HashSet();

        String s = new String("a");
        System.out.println(s.hashCode());

        int[] ax = {1, 4, -1, 5, 0};
        Arrays.sort(ax);
        //数组a[]的内容变为{-1,0,1,4,5}
        for (int i = 0; i < ax.length; i++)
            System.out.print(ax[i] + "  ");
    }

}
