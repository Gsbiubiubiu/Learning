package com.gs.juc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @User远
 * @Date2022/3/3
 */

/**
 * java内置核心四大函数式接口
 * <p>
 * 函数式接口       参数类型        返回类型        用途
 * Consumer<T>     T               void        对类型为T的对象应用操作，包含方法:
 * 消费型接口                                    void accept(T t)
 * <p>
 * Supplier<T>      无              T           返回类型为T的对象，包含方法：
 * 供给型接口                                     T get();
 * <p>
 * Function<T, R>  T                R          对类型为T的对象应用操作，并返回结果，结果是R类型对象，包含方法：
 * 函数型接口                                     R apply(T t)
 * <p>
 * Predicate<T>
 * 断定型接口        T              boolean       确定类型为T的对象是否满足某约束，并返回Boolean，包含方法：
 * boolean test(T t)
 */
public class StreamDemo {


    public static void main(String[] args) {
        consumer();
    }


    private static void consumer() {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//
//            }
//        };
        Consumer<String> consumer = s -> {
            System.out.println(s);
        };
        consumer.accept("consumer");
        getList().forEach(System.out::println);
    }

    /**
     * 1.偶数id且年龄大于24
     * 2.用户名转为大写
     * 3.用户名字母倒排序
     * 4.只输出一个用户名
     *
     * @return
     */

    private static void streamList() {
        List<User> list = getList();
        List<String> collect = list.stream().filter(x -> x.getId() % 2 == 0).filter(x -> x.getAge() > 24).map(x -> x.getUserName().toUpperCase()).sorted().limit(1).collect(Collectors.toList());

    }

    private static List<User> getList() {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);
        return Arrays.asList(u1, u2, u3, u4, u5);
    }


    static class User {
        private int id;
        private String userName;
        private int age;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public User(int id, String userName, int age) {
            this.id = id;
            this.userName = userName;
            this.age = age;
        }

    }
}
