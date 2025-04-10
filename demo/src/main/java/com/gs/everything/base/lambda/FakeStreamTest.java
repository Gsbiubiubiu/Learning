package com.gs.everything.base.lambda;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Gaos
 * @Date: 2023-02-21 11:42
 *
 *
 * 山寨版 Stream API
 **/
public class FakeStreamTest {

    public static void main(String[] args) {
        MyList<Person> personMyList = new MyList<>();
        personMyList.add(new Person("李健", 46));
        personMyList.add(new Person("周深", 28));
        personMyList.add(new Person("张学友", 59));

        // 需求：过滤出年龄大于40的歌手的名字

        // 山寨版 Stream
        personMyList.filter(person -> person.getAge() > 40).map(Person::getName);
        prettyPrint(personMyList);

        System.out.println("\n---------------------------------\n");

        // 对比真正的Stream API
        List<Person> list = new ArrayList<>();
        list.add(new Person("李健", 46));
        list.add(new Person("周深", 28));
        list.add(new Person("张学友", 59));

        List<String> collect = list.stream()  // 真正的Stream Api需要先转成Stream流
                .filter(person -> person.getAge() > 40) // 过滤出年纪大于40的歌手
                .map(Person::getName)   // 拿到他们的名字
                .collect(Collectors.toList()); // 整理成List<String>
        prettyPrint(collect);
    }

    /**
     * 按照json格式输出
     * @param obj
     */
    private static void prettyPrint(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writerWithDefaultPrettyPrinter().toString();
        System.out.println(s);
    }


}
@Data
@AllArgsConstructor
class Person {
    private String name;
    private Integer age;
}


@Getter
class MyList<T> {

    private List<T> list = new ArrayList<>();

    public boolean add(T t) {
        return list.add(t);
    }

    /**
     * 给 MyList传递具体的判断规则， 然后MyList把内部符合内部符合判断的元素集返回
     * @param predicate
     * @return
     */
    public MyList<T> filter(Predicate<T> predicate) {
        MyList<T> filteredList = new MyList<>();
        for (T t : list) {
            if(predicate.test(t)) {
                // 收集判断为true的元素
                filteredList.add(t);
            }
        }
        return filteredList;
    }

    /**
     * 将MyList中的List<T> 转为List<R>
     * @param mapper
     * @return
     * @param <R>
     */
    public <R> MyList<R> map(Function<T, R> mapper) {
        MyList<R> mappedList = new MyList<>();
        for (T t : list) {
            mappedList.add(mapper.apply(t));
        }
        return mappedList;
    }
}

/**
 * 定义一个 Predicate接口
 * @param <T>
 */
@FunctionalInterface
interface Predicate<T> {
    /**
     * 定义一个 test()方法，传入人一对象， 返回true or false， 具体判断逻辑由子类实现
     * @param t
     * @return
     */
    boolean test(T t);
}

/**
 * 定义一个Function接口
 * @param <E>
 * @param <R>
 */
@FunctionalInterface
interface Function<E, R> {

    /**
     * 定义一个apply()方法，接受一个E 返回一个 R 。也就是将E映射为R
     * @param e
     * @return
     */
    R apply(E e);
}
