package com.star.pdf;


import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class FilesTest {

    public static void main(String[] args) {

        Path path = Paths.get("/Users/lichunxia/Documents/work/江南大学");
        Path path2 = Paths.get("/Users/lichunxia/Documents/work/江南");
        String destPathRoot = "/Users/lichunxia/Documents/work/江南";
        String fileSeperater = File.separator;
        Map<String, String> dhMap = new HashMap<>();

//        Stream<Path> pathStream = Files.walk(path);
//        pathStream.limit(10).forEach(System.out::println);
//        System.out.println("---------");
//        pathStream.filter(Files::isDirectory).forEach(System.out::println);
//        pathStream.filter(Files::isDirectory);

        try {
            Files.walkFileTree(path, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("preVisitDirectory : " + dir + " --- " + dir.getFileName());
                    String destPath = destPathRoot + dir.toString().substring(path.toString().length());
                    System.out.println("目标PATH : " + destPath);
//                    Files.createDirectories(Paths.get(destPath));
//                    System.out.println("resolve : " + dir.getParent().resolve(path2));
                    return FileVisitResult.SKIP_SUBTREE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("visitfile : " + file);
                    String parent = file.getParent().toString();
                    dhMap.put(parent.substring(parent.lastIndexOf(fileSeperater) + 1), parent);
                    return FileVisitResult.SKIP_SIBLINGS;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
//                    System.out.println("postVisitDirectory : " + dir);
//                    Files.createDirectories(Paths.get(path3 + dir.getFileName()));
                    System.out.println("postVisitDirectory : " + dir.getFileName());
//                    Paths.get(path3 + dir.getFileName());
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(dhMap);

    }

}
