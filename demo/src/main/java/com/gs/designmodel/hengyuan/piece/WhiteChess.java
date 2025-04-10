package com.gs.designmodel.hengyuan.piece;

import java.awt.*;

/**
 * @author: Gaos
 * @Date: 2023-07-28 10:19
 **/
public class WhiteChess implements Chess{

    private final Color color = Color.WHITE;

    private final String sharp = "圆形";

    public Color getColor() {
        return color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("棋子形状:" + sharp);
        System.out.println("棋子颜色:" + color.toString());
        System.out.println("x轴坐标:" + x);
        System.out.println("y轴坐标:" + y);
    }
}