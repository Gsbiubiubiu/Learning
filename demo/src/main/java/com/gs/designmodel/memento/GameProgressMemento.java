package com.gs.designmodel.memento;

/**
 * @author: Gaos
 * @Date: 2023-08-22 18:38
 **/
public class GameProgressMemento {

    private int score;

    public GameProgressMemento(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}