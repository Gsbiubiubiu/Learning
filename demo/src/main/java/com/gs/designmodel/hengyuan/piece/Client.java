package com.gs.designmodel.hengyuan.piece;

import java.awt.*;

/**
 * @author: Gaos
 * @Date: 2023-07-28 10:32
 **/
public class Client {
    public static void main(String[] args) {
        // 黑子说话
        Chess blackChess1 = ChessFactory.getChess(Color.BLACK);
        blackChess1.draw(2, 5);

        // 白子说话
        Chess whiteChess1 = ChessFactory.getChess(Color.WHITE);
        whiteChess1.draw(3, 5);

        // 黑子又说话
        Chess blackChess2 = ChessFactory.getChess(Color.BLACK);
        blackChess2.draw(8, 6);

        System.out.println("黑子1:" + blackChess1.hashCode());
        System.out.println("黑子2：" + blackChess2.hashCode());
        System.out.println("白子1" + whiteChess1.hashCode());
    }
}