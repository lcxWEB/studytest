package com.star.file;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileTest {


    public static void main(String[] args) {

        String picRootPath = "/Users/lichunxia/Documents/work/third-house/pics";
        File file = new File(picRootPath);

        File[] files = file.listFiles();
        System.out.println(Arrays.toString(files));
        System.out.println(file.getParent());
        HashMap<String, String> map = new LinkedHashMap();
        System.out.println(System.currentTimeMillis());
        findAllDhPath(file, map);
        System.out.println(System.currentTimeMillis());
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.get("0987").substring(picRootPath.length()));

        File[] imgs = new File(map.get("0001")).listFiles();

        for (File img : imgs) {
            System.out.println(img.getPath());
            int imgInt = 0;
            try {
                imgInt = Integer.parseInt(img.getName().substring(0, img.getName().lastIndexOf('.')));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(imgInt);
        }


    }


    private static void findAllDhPath(File src, Map map) {
        if (src.isDirectory()) {
            File[] files = src.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    String parent = file.getParent();
                    map.put(parent.substring(parent.lastIndexOf('/') + 1), parent);
//                    return;
                }
                findAllDhPath(file, map);
            }
        }

    }

}
