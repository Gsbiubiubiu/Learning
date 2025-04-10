package com.gs.designmodel.memento;

/**
 * @author: Gaos
 * @Date: 2023-08-22 18:46
 **/
public class Test {
    public static void main(String[] args) {
        GameOriginator originator = new GameOriginator();
        GameCareTaker careTaker = new GameCareTaker();
        // 客户端需要维护一个指针和备忘录的次序相对应
        int index = 0;
        // 玩游戏
        originator.playGame();
        // 保存进度
        careTaker.saveMemento(originator.saveProcess());
        // 退出游戏
        originator.exitGame();

        // 重新打开游戏恢复进度
        originator.restoreProcess(careTaker.getMemento(index));
        originator.playGame();
    }
}