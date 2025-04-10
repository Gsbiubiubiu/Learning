package com.gs.designmodel.decoratemodel.filedemo;

/**
 * @author: Gaos
 * @Date: 2023-01-17 14:50
 **/
public class DemoTest {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("/Users/gaosheng/test")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("/Users/gaosheng/test");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}