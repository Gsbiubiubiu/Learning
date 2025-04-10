package com.gs.designmodel.decoratemodel.filedemo;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;

/**
 * @author: Gaos
 * @Date: 2023-01-17 14:04
 *
 * 简单的数据读写器(通用数据接口的具体实现)
 **/
public class FileDataSource implements DataSource{

    private String name;

    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        File file = new File(name);
        try (OutputStream fos = Files.newOutputStream(file.toPath())) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(name);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
        return new String(Objects.requireNonNull(buffer));
    }
}