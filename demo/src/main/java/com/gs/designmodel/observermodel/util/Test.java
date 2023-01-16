package com.gs.designmodel.observermodel.util;

/**
 * @author: Gaos
 * @Date: 2022-11-01 00:09
 **/
public class Test {
    public static void main(String[] args) {
        SubjectFor3D subjectFor3D = new SubjectFor3D();
        SubjectForSSQ subjectForSSQ = new SubjectForSSQ();

        Observer1 observer1 = new Observer1();
        observer1.registerSubject(subjectFor3D);
        observer1.registerSubject(subjectForSSQ);

        subjectFor3D.setMessage("hello 3d");
        subjectForSSQ.setMessage("hello ssq");
    }
}