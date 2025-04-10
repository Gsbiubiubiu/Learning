package com.gs.designmodel.decoratemodel.filedemo;

import java.util.Base64;

/**
 * @author: Gaos
 * @Date: 2023-01-17 14:27
 *
 * 加密装饰
 **/
public class EncryptionDecorator extends DataSourceDecorator{

    public EncryptionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {
        super.writeData(encode(data));
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }

    /**
     * 加密方法
     * @param data
     * @return
     */
    private String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}