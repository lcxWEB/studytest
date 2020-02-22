package com.star;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.star.util.DateUtils;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lcx on 2018/10/12.
 */


public class MainTest {

    final int d = 0;
    int v;

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

        System.out.println();
        System.out.println(Arrays.toString(ax));

        String[] yeHaoArray = {"ff", "df", "ggg", ""};
        List<String> yeHaoList = Arrays.asList(yeHaoArray);
        System.out.println("yehaolist : " + yeHaoList);
//        for (int i = 0; i < yeHaoList.size(); i++) {
//            if (StringUtils.isEmpty(yeHaoList.get(i))) {
//                yeHaoList.remove(yeHaoList.get(i));
//            }
//        }

        List<String> yeHaoList2 = new ArrayList<>();
        for (int i = 0; i < yeHaoArray.length; i++) {
            if (!StringUtils.isEmpty(yeHaoArray[i])) {
                yeHaoList2.add(yeHaoArray[i]);
            }
        }
        System.out.println("yeHaoList2: " + yeHaoList2);
        try {
            Integer.parseInt("dfdfd");
        } catch (Exception e) {
        }
        System.out.println(yeHaoList2);

        int[] yehaoArr = new int[yeHaoList2.size()];
        for (int i = 0; i < yehaoArr.length; i++) {
            try {
                yehaoArr[i] = Integer.parseInt(yeHaoList2.get(i));
            } catch (Exception e) {
//                log.info("页号非法，无法转换为数字 ：{}", yeHaoList.get(i));
            }
        }

        for (int i = 0; i < yehaoArr.length; i++) {
            System.out.println("yehaoArr: " + yehaoArr[i]);
        }
        System.out.println(Arrays.toString(yehaoArr));
        System.out.println(Arrays.asList(yehaoArr));


        List<String> strings = new ArrayList<>();
        for (String s1 : strings) {
            System.out.println("string : " + s1);
        }


        List<Integer> integers = new ArrayList<>();
        integers.add(9);
        integers.add(8);
        System.out.println(integers);
        Collections.sort(integers);
        System.out.println(integers);

//        System.out.println(Integer.parseInt(null));


        System.out.println(Arrays.asList(1, 2, 3));


        String timeStr = DateUtil.format(DateTime.now(), "yyyy-MM-dd-HH-mm-ss");
        System.out.println(timeStr);

        System.out.println(LocalDateTime.now());


        Instant now = Instant.now();
        Instant date = Instant.parse("2007-12-03T10:15:30.00Z");
        // date = Instant.parse("2019-08-01");
        date = Instant.ofEpochSecond(0000);
        LocalDate localDate = LocalDate.now();
        LocalDate date1 = LocalDate.of(2018, 9, 22);
        Period period = Period.between(localDate, date1);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());



        List<String> patternList = new ArrayList<>();
        patternList.add("yyyy-MM-dd");
        patternList.add("yyyy-M-d");
        patternList.add("yyyy.MM.dd");
        patternList.add("yyyy.M.d");
        patternList.add("yyyy/MM/dd");
        patternList.add("yyyy/M/d");
        patternList.add("yyyy年MM月dd日");
        patternList.add("yyyy年M月d日");

        // DateTime dateTime = DateUtil.parse(newValue, newPattern);

        String value = "2017/3/1";
        for (String pattern : patternList) {
            if (StrUtil.count(pattern, "年") > 0 && StrUtil.count(value, "年") > 0) {
                //中文用横杠替换
                value = DateUtils.replaceCN(value);
                pattern = "yyyy-MM-dd";
            }
            try {
                date1 = LocalDate.parse(value, DateTimeFormatter.ofPattern(pattern));
            } catch (Exception e) {
                // e.printStackTrace();
            }
        }

        System.out.println(date1);

    }
}
