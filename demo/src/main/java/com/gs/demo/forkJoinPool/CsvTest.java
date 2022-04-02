package com.gs.demo.forkJoinPool;

import com.opencsv.CSVReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @User远
 * @Date2022/3/23
 */
public class CsvTest {
    public static void main(String[] args) throws Exception {
        testHasResultTask();
    }
    public static void testHasResultTask() throws Exception {
        String path = "F:\\secsmart\\gs_guest.csv";
        String encode = "utf-8";
        Reader reader = new InputStreamReader(new FileInputStream(path), encode);
        CSVReader csvReader = new CSVReader(reader);
        String[] labels = csvReader.readNext();
        List<String[]> items = csvReader.readAll();
        long time = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Map<Integer, Set<String>>> submit = pool.submit(new CsvTask(items, labels));
        Map<Integer, Set<String>> map = submit.get();
        map.forEach((x,y)->{
            System.out.println("key:" + x +"value+" + y);
        });
        long costTime = System.currentTimeMillis()-time;
        System.out.println("耗费时间"+ costTime);
//        int result1 = 0;
//        long time = System.currentTimeMillis();
//        for (int i = 1; i <= 1000000; i++) {
//            result1 += i;
//        }
//        long costTime = System.currentTimeMillis()-time;
//        System.out.println("循环计算 1-1000000 累加值：" + result1 + "耗时：" + costTime);
//
//        ForkJoinPool pool = new ForkJoinPool();
//        ForkJoinTask<Integer> task = pool.submit(new CsvTask(1, 1000000));
//        int result2 = task.get();
//        costTime = System.currentTimeMillis()-time;
//        System.out.println("并行计算 1-1000000 累加值：" + result2 + "耗时：" + costTime);
//        pool.awaitTermination(2, TimeUnit.SECONDS);
//        pool.shutdown();

    }
}


class CsvTask extends RecursiveTask<Map<Integer, Set<String>>> {

    private static final long serialVersionUID = 1L;
    private List<String[]> item;
    private String[] label;
    Map<Integer, Set<String>> map = new HashMap<>();
    public CsvTask(List<String[]> item, String[] label) {
        this.item = item;
        this.label = label;
    }



    @Override
    protected Map<Integer, Set<String>> compute() {

        for (int i = 0; i < label.length; i++) {
            //Vector<String> set = new Vector<>();
            Set<String> set = new HashSet<>();
            map.put(i, set);
        }
        if (item.size() < 5000) {
            for (int i = 0; i < label.length; i++) {
                for (String[] strings : item) {
                    String type = getType(strings[i]);
                    Set<String> strings1 = map.get(i);
                    strings1.add(type);
                    map.put(i, strings1);
                }
            }
            System.out.println(Thread.currentThread().getName() + "++++++++");
            return map;
        } else {
            List<ForkJoinTask> tasks = new ArrayList<>();
            List<List<String[]>> lists = averageAssign(item, 2);
            for (int i = 0; i < lists.size(); i++) {
                CsvTask csvTask = new CsvTask(lists.get(i), label);
                tasks.add(csvTask.fork());
            }
            Map<Integer, Set<String>> finalmap = new HashMap<>();
            for (int i = 0; i < label.length; i++) {
                //Vector<String> set = new Vector<>();
                Set<String> set = new HashSet<>();
                finalmap.put(i, set);
            }
//            tasks.forEach(x -> {
//                Map<Integer, Set<String>> join = x.join();
//                for (int i = 0; i < finalmap.size(); i++) {
//                    finalmap.get(i).addAll(join.get(i));
//                    Set<String> stringSet = finalmap.get(i);
//                    stringSet.addAll(join.get(i));
//                    finalmap.put(i, stringSet);
//                }
//            });
            for (int i = 0; i < tasks.size(); i++) {
//                Map<Integer, Set<String>> join = tasks.get(i).join();
                Map<Integer, Set<String>> join = (Map<Integer, Set<String>>) tasks.get(i).join();
                for (int j = 0; j < finalmap.size(); j++) {
//                    finalmap.get(j).addAll(join.get(j));
                    Set<String> stringSet = finalmap.get(j);
                    stringSet.addAll(join.get(j));
                    finalmap.put(j, stringSet);
                }
            }
            return finalmap;
//        ConcurrentHashMap<Integer, Set<String>> finalmap = new ConcurrentHashMap();
//        tasks.forEach(x->{
//            Map<Integer, Vector<String>> join = x.join();
//            for (int i = 0; i < label.length; i++) {
//
//            }
//        });
        }
    }
    public String getType(String s){
        if(s.length()>4){
            return "1";
        }else {
            return "2";
        }
    }
    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        int remainder = source.size() % n;  //(先计算出余数)
        int number = source.size() / n;  //然后是商
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }

    public Map getMap(){
        return map;
    }
}
