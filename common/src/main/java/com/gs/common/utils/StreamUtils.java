package com.gs.common.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @User远
 * @Date2022/2/22
 */
public class StreamUtils {

    public static ByteArrayOutputStream readToBytes(InputStream is) throws IOException {
        if (is == null) return null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[2048];
            while (true) {
                int len = is.read(buf, 0, 2048);
                if (len == -1) {
                    break;
                }
                baos.write(buf, 0, len);
            }
            return baos;
        } finally {
            is.close();
        }
    }

    public static String readToString(InputStream is) throws IOException {
        return readToString(is, "UTF-8");
    }

    public static String readToString(InputStream is, String encode) throws IOException {
        ByteArrayOutputStream baos = readToBytes(is);
        if (baos == null) return null;

        return baos.toString(encode);
    }

    public static void write(String str, OutputStream os) throws IOException {
        os.write(str.getBytes(StandardCharsets.UTF_8));
    }

    public static void writeToFile(String str, File file) throws IOException {
        try (OutputStream ops = new FileOutputStream(file)) {
            write(str, ops);
        }
    }

    public static String writeToTmpFile(String data) throws IOException {
        File file = File.createTempFile("tmp", ".tmp");
        writeToFile(data, file);
        return file.getAbsolutePath();
    }

    public static String readFromFile(File file) throws IOException {
        try (InputStream ips = new FileInputStream(file)) {
            return readToString(ips);
        }
    }

    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = StreamUtils.class.getClassLoader().getResourceAsStream("components.json");
        InputStream resourceAsStream1 = StreamUtils.class.getResourceAsStream("/com/example/demo/test/component.json");
//        InputStream resourceAsStream1 = ResourcesTest.getClass().getResourceAsStream("component.json");
        System.out.println(resourceAsStream1);
        String string = StreamUtils.readToString(resourceAsStream);
        String string1 = StreamUtils.readToString(resourceAsStream1);
        System.out.println(string);
        System.out.println(string1);
    }
}
