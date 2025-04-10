package com.gs.designmodel.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gaos
 * @Date: 2023-08-22 18:38
 **/
public class GameCareTaker {

    private List<GameProgressMemento> mementos  = new ArrayList<>();

    /**
     * 保存状态
     * @param memento
     */
    public void saveMemento(GameProgressMemento memento) {
        this.mementos.add(memento);
    }

    /**
     * 恢复状态
     * @param index
     * @return
     */
    public GameProgressMemento getMemento(int index) {
        return this.mementos.get(index);
    }
}