package com.gs.designmodel.hengyuan.tree;

import java.awt.*;

/**
 * @author: Gaos
 * @Date: 2023-07-26 11:49
 **/
public class Tree {

    private int x;

    private int y;

    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        type.draw(g, x, y);
    }
}