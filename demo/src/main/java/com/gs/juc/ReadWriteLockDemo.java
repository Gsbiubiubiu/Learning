package com.gs.juc;

/**
 * @User远
 * @Date2022/3/1
 */

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *      多个线程同时去读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 *      但是 如果有一个线程想去写共享资源，就不应该再有其他线程可以对该资源进行读或写
 *      eg：
 *          读-读 共存
 *          读-写 不能共存
 *          写-写 不能共存
 */
class FailMyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+ "\t----写入数据"+key);
        TimeUnit.MILLISECONDS.sleep(300);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName()+ "\t----写入完成");
    }

    public void get(String key) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"\t ----读入数据");
        TimeUnit.MILLISECONDS.sleep(300);
        Object result = map.get(key);
        System.out.println(Thread.currentThread().getName()+"\t 读取完成" + result);
    }
}

class SuccessfulMyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key, Object value){
        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+ "\t----写入数据"+key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+ "\t----写入完成");
        }catch (Exception e){
            System.out.println(e);
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t ----读入数据");
            TimeUnit.MILLISECONDS.sleep(300);
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成" + result);
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}


public class ReadWriteLockDemo {
    public static void main(String[] args) {
        successfulTest();
    }

    private static void successfulTest() {
//        FailMyCache myCache = new FailMyCache();
        SuccessfulMyCache myCache = new SuccessfulMyCache();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.put(finalI+"", finalI+"");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(()->{
                myCache.get(finalI+"");
            }, String.valueOf(i)).start();
        }
    }



//    public static class MyCatch {
//
//    }
}
