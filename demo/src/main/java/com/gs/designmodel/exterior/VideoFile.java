package com.gs.designmodel.exterior;

/**
 * @author: Gaos
 * @Date: 2023-01-30 17:23
 **/
public class VideoFile {

    private String name;
    private String codecType;

    public VideoFile(String name) {
        this.name = name;
        this.codecType = name.substring(name.indexOf(".") + 1);
    }

    public String getName() {
        return name;
    }

    public String getCodecType() {
        return codecType;
    }
}