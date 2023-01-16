package com.gs.everything.base.objectandthis;

/**
 * @author: Gaos
 * @Date: 2022-11-11 17:48
 **/
public class Demo {
    public static void main(String[] args) {
        /**
         * new一个子类对象
         * 我们知道，子类对象实例化时，会隐式调用父类的无参构造
         * 所以Father里的System.out.println()会执行
         * 猜猜打印的内容是什么？
         */
        Son son = new Son();
        Daughter daughter = new Daughter();
    }
}
 class Father{
    /**
     * 父类构造器
     */
    public Father() {
        System.out.println(this.getClass().getName());
    }
}
class Son extends Father {
    public Son(){
        // 其实就是隐式调用了这个方法
        // 传递的是this对象 没有什么特别的
        super();
    }
}

class Daughter extends Father {

}
/**
 * 这样一解释，刚才的案例就没什么神秘感了：嗨，不就是方法调用传参嘛！
 *
 * 本质和子类调用方法给父类传参一样一样的！只不过传参的过程很特殊：
 * ● new的时候自动传参，不是我们主动调用，所以感知不到
 * ● Java中的this是隐式传递的，所以我们更加注意不到了
 *
 * 我们会在后面用到这个小特性，它对于封装通用工具类非常有用。
 */