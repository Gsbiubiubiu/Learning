package com.gs.everything.base.faceobject;

/**
 * @author: Gaos
 * @Date: 2023-01-12 11:51
 **/
public class DuoTai {
    // 多态 ---》继承多态和接口多态
    // 继承多态
    public static void main(String[] args) {
        Father2 obj = new Son();
        obj.smoke();

        obj = new Daughter();
        obj.smoke();
    }


}
class Son extends Father2 {
    @Override
    void smoke() {
        System.out.println("儿子抽烟");
    }
}

class Daughter extends Father2 {
    @Override
    void smoke() {
        System.out.println("女儿抽烟");
    }
}
abstract class Father2 {
    abstract void smoke();
}