package com.gs.everything.base.usefulleetcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Gaos
 * @Date: 2022-10-26 14:39
 **/
@Slf4j
public class Demo {

    public static void main(String[] args) {
        // 老公组
        List<Couple> husbands = new ArrayList<Couple>(){{
            add(new Couple(1, "梁山伯"));
            add(new Couple(2, "牛郎"));
            add(new Couple(3, "干将"));
            add(new Couple(4, "工藤新一"));
            add(new Couple(5, "罗密欧"));
        }};

        //老婆组
        List<Couple> wives = new ArrayList<Couple>(){{
            add(new Couple(1, "祝英台"));
            add(new Couple(2, "织女"));
            add(new Couple(3, "莫邪"));
            add(new Couple(4, "毛利兰"));
            add(new Couple(5, "朱丽叶"));
        }};
        /**
         * 要求对数据进行处理，最终输出
         * 梁山伯爱祝英台
         * 牛郎爱织女
         * 干将爱莫邪
         * 工藤新一爱毛利兰
         * 罗密欧爱朱丽叶
         */
        // 第一版算法 25次
        // firstCode(husbands, wives);
        // 第二版算法 15次
        // twoCode(husbands, wives);

        // 第三版算法 5次
        // threeCode(husbands, wives);

        // 第四版算法 10次
        fourCode(husbands, wives);
    }

    /**
     * 第四版算法
     *  改进点：
     *      是否一定要使用双重for循环呢？
     *      todo：其实无论何时，当我们使用for循环的时候就潜意识里已经把数据泛化了，牺牲数据的特性而谋求统一的操作方式。
     *      他需要循环的问每个女嘉宾，才知道哪个女嘉宾是爱他的，所以对于男嘉宾来说，女嘉宾对他来说就是无差异的黑盒。
     *
     *      那如果我们给场上的女嘉宾发一个牌子，让他们填上自己喜欢男嘉宾的号码，男嘉宾就不需要挨个的问了，直接找到写有自己号码的女嘉宾就ok了
     *      这样就避免了for循环
     *      todo: 这个算法的思想就是让数据产生差异化，外部通过差异快速定位数据
     *      这样比较稳定，不会因为数据的差异，而对循坏次数产生太大的影响。
     *      todo：它的精髓就是利用HashMap给其中一列数据加了“索引”，每个数据的“索引”（Map的key）是不同的，让数据差异化。
     *
     */
    private static void fourCode(List<Couple> husbands, List<Couple> wives) {
        int count = 0;
        Map<Integer, Couple> wiveMap = new HashMap<>();
        for (Couple wife : wives) {
            wiveMap.put(wife.getFamilyId(), wife);
            count++;
        }

        for (Couple husband : husbands) {
            Couple wife = wiveMap.get(husband.getFamilyId());
            log.info(" {} 爱 {}", husband.getUserName(), wife.getUserName());
            count++;
        }
        log.info("-----------------------------------");
        log.info(" 循环次数 {}次", count);
    }


    /**
     * 第三版算法
     * 改进点：
     *      在非诚勿扰中，女嘉宾在牵手完之后就该下台了
     *      但在代码中，梁山伯已经牵手了祝英台，但在牛郎的循环中还是会循环祝英台，这是不合理的，也是没有意义的
     * 优点：
     *      执行效率比第二版高
     * 缺点：
     *      理解难度高点，平均性能不高
     *
     *      平均性能不高的理解：list内本身的排序会影响到执行的结果，五次是最理想的情况下的结果
     *      如果是将男方倒叙，女方每次移除的都是最末的元素，那么就无法将上一个男方移除的优势体现，他还是要把其他错的体验一边
     *      所以在这种情况下，也有可能循环15次，所以平均性能不高
     */
    private static void threeCode(List<Couple> husbands, List<Couple> wives) {
        int count = 0;
        for (Couple husband : husbands) {
            for (Couple wife : wives) {
                count++;
                if(husband.getFamilyId().equals(wife.getFamilyId())) {
                    log.info(" {} 爱 {}", husband.getUserName(), wife.getUserName());
                    log.info(" 牵手成功，女嘉宾下台");
                    wives.remove(wife);
                    log.info(" 牵手成功，换下位男嘉宾");
                    break;
                }
            }
        }
        log.info("-----------------------------------");
        log.info(" 循环次数 {}次", count);
    }

    /**
     * 第二版算法
     *  改进点：
     *      在目前的情况下，一个男方只能匹配一个女方，所以当二层循环匹配上之后就没有必要再继续循环了
     *      所以正确做法，应该是在匹配上后跳出当前循环，开始匹配下个男方，可以减少无效的循环次数
     *  优点：执行效率比第一版高
     *  缺点：理解难度提升了一点
     */
    private static void twoCode(List<Couple> husbands, List<Couple> wives) {
        int count = 0;
        for (Couple husband : husbands) {
            for (Couple wife : wives) {
                count++;
                if(husband.getFamilyId().equals(wife.getFamilyId())) {
                    log.info(" {} 爱 {}", husband.getUserName(), wife.getUserName());
                    log.info(" 牵手成功，换下位男嘉宾 ");
                    break;
                }
            }
        }
        log.info("-----------------------------------");
        log.info(" 循环次数 {}次", count);
    }



    /**
     * 第一版算法 直接进行比较 以完成需求为目的出发
     * 优点：逻辑简单，代码直观
     * 缺点：循环次数过多，数据量小的情况下无所谓，在大数据的情况下
     *      如果男女各1000人， 那将循环 1000*1000 = 100w次
     * @param husbands
     * @param wives
     */
    private static void firstCode(List<Couple> husbands, List<Couple> wives) {
        int count = 0;
        for (Couple husband : husbands) {
            for (Couple wife : wives) {
                count++;
                if(husband.getFamilyId().equals(wife.getFamilyId())) {
                    log.info(" {} 爱 {}", husband.getUserName(), wife.getUserName());
                }
            }
        }
        log.info("-----------------------------------");
        log.info(" 循环次数 {}次", count);
    }

    @Data
    @AllArgsConstructor
    static class Couple {
        private Integer familyId;
        private String userName;
    }
}