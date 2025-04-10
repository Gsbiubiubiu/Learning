package com.gs.designmodel.memento;

/**
 * @author: Gaos
 * @Date: 2023-08-22 18:35
 **/
public class GameOriginator {

    private int currentScore;

    /**
     * 将需要保存的状态封装在Memento里对外提供
     * @return
     */
    public GameProgressMemento saveProcess() {
        return new GameProgressMemento(currentScore);
    }

    /**
     * 通过从外部接收的Memento恢复状态
     * @param memento
     */
    public void restoreProcess(GameProgressMemento memento) {
        currentScore = memento.getScore();
    }

    public void playGame() {
        System.out.println("Game Begin---");
        System.out.println("当前分数为： " + currentScore);
        System.out.println("击杀小兵得一分");
        currentScore++;
        System.out.println("总分为: " + currentScore);
    }

    public void  exitGame() {
        System.out.println("退出游戏");
        currentScore = 0;
        System.out.println("Game End-----");
    }
}