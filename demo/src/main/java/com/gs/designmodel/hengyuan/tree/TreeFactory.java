package com.gs.designmodel.hengyuan.tree;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Gaos
 * @Date: 2023-07-26 11:56
 **/
public class TreeFactory {

    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String otherTreeData) {
        TreeType result = treeTypes.get(name);
        if(result == null) {
            result = new TreeType(name, color, otherTreeData);
            treeTypes.put(name, result);
        }
        return result;
    }
}